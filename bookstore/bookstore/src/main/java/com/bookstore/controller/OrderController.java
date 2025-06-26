package com.bookstore.controller;

import com.bookstore.entity.*;
import com.bookstore.repository.*;
import com.bookstore.request.OrderRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin(value = "http://localhost:4200", allowCredentials = "true")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    @PostMapping("/placeorder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request, HttpSession session) {

        Integer sessionUserId = (Integer) session.getAttribute("userid");
        if (sessionUserId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "User is not logged in."));
        }

        User user = userRepository.findById(sessionUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = addressRepository.findById(request.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        if (address.getUser() == null || address.getUser().getId() != (sessionUserId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Address does not belong to the user."));
        }

        // Fetch the user's cart
        Cart cart = cartRepository.findByUser_Id(sessionUserId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        List<CartItems> cartItems = cart.getCartItems();
        if (cartItems.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Cart is empty."));
        }

        // Create the order
        Orders order = new Orders();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setExpectedDate(order.getOrderDate().plusDays(10));
        order.setAddress(address);
        order.setPaymentMethod(request.getPaymentMethod());

        List<OrderItems> orderItems = new ArrayList<>();
        double total = 0.0;

        for (CartItems cartItem : cartItems) {
            Book book = cartItem.getBook();

            OrderItems orderItem = new OrderItems();
            orderItem.setBookid(book.getId());
            orderItem.setTitle(book.getTitle());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setOrders(order);

            orderItems.add(orderItem);
            total += cartItem.getPrice();
        }

        order.setOrderItems(orderItems);
        order.setTotalAmount(total);

        // Save order and items
        orderRepository.save(order);

        // Clear cart items
        cart.getCartItems().clear();
        cartRepository.save(cart);

        return ResponseEntity.ok(Map.of("message", "Order placed successfully."));
    }


    @GetMapping("/get")
    public ResponseEntity<List<Orders>> getOrders(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<Orders> orders = orderRepository.findAllByUser_Id(userId);
        return ResponseEntity.ok(orders);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Integer orderId, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "User is not logged in."));
        }

        Optional<Orders> orderOpt = orderRepository.findById(orderId);

        if (orderOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Order not found."));
        }

        Orders order = orderOpt.get();

        if (order.getUser().getId() != userId) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Access denied. This order does not belong to the current user."));
        }


        return ResponseEntity.ok(order);
    }


    @GetMapping("/latest")
    public ResponseEntity<?> getLatestOrder(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "User is not logged in."));
        }

        Orders latestOrder = orderRepository.findTopByUser_IdOrderByOrderDateDesc(userId);

        if (latestOrder == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "No orders found for the user."));
        }

        return ResponseEntity.ok(latestOrder);
    }

}
