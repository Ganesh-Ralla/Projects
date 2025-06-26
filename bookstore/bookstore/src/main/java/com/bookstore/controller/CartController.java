package com.bookstore.controller;

import com.bookstore.entity.Cart;
import com.bookstore.repository.CartRepository;
import com.bookstore.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin(value = "http://localhost:4200", allowCredentials = "true")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/get")
    public ResponseEntity<?> getCart(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("User not logged in");
        }

        Optional<Cart> optionalCart = cartRepository.findByUser_Id(userId);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            // Initialize lazy loading for cart items and books if needed
            cart.getCartItems().forEach(cartItem -> {
                if (cartItem.getBook() != null) {
                    cartItem.getBook().getTitle();
                }
            });

            return ResponseEntity.ok(cart);
        } else {
            // Return empty Cart or suitable response
            return ResponseEntity.ok(new Cart());
        }
    }
}
