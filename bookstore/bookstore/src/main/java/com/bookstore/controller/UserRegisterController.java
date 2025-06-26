package com.bookstore.controller;

import com.bookstore.entity.Address;
import com.bookstore.entity.Cart;
import com.bookstore.entity.Orders;
import com.bookstore.entity.User;
import com.bookstore.repository.*;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
public class UserRegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public User registerUser(@RequestBody User user) {
        // Save the user first
        User currentUser = userRepository.save(user);

        // Create and save a cart linked to this user
        Cart cart = new Cart();
        cart.setUser(currentUser);
        Cart savedCart = cartRepository.save(cart);
        currentUser.setCart(savedCart);

        // Save again
        return userRepository.save(currentUser);
    }

    @GetMapping("/get")
    public User getUser(HttpSession session) {
        Integer userid = (Integer) session.getAttribute("userid");

        if (userid == null) {
            throw new RuntimeException("User not logged in");
        }

        return userRepository.findById(userid).orElse(null);
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity<Map<String, String>> deleteUser(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "User not logged in"));
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Explicitly load cart items and delete
        if (user.getCart() != null) {
            Cart cart = cartRepository.findById(user.getCart().getId()).orElse(null);
            if (cart != null) {
                cartItemRepository.deleteAll(cart.getCartItems());
                cartRepository.delete(cart);
            }
        }

        // Explicitly fetch and delete orders
        List<Orders> orders = orderRepository.findByUserId(userId);
        if (!orders.isEmpty()) {
            orderRepository.deleteAll(orders);

        }
        orderRepository.flush();

        // Explicitly fetch and delete addresses
        List<Address> addresses = addressRepository.findByUserId(userId);
        if (!addresses.isEmpty()) {
            addressRepository.deleteAll(addresses);
        }
        addressRepository.flush();

        // Now delete user
        userRepository.delete(user);

        session.invalidate();

        return ResponseEntity.ok(Map.of("message", "User and related data deleted successfully"));
    }


}
