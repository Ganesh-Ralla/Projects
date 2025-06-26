package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.entity.CartItems;
import com.bookstore.entity.User;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.repository.CartRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.request.CartItemRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cartitems")
@CrossOrigin(value = "http://localhost:4200", allowCredentials = "true")
public class CartItemController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/additem")
    public ResponseEntity<CartItems> addItems(@RequestBody CartItemRequest request, HttpSession session) {
        Integer userid = (Integer) session.getAttribute("userid");
        if (userid == null) {
            throw new RuntimeException("User not logged in");
        }

        User user = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));

        Book book = bookRepository.findById(request.getBookid())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        int currentStock = book.getStock();
        int requestedQty = request.getQuantity();

        if (requestedQty > currentStock) {
            throw new RuntimeException("Not enough stock available");
        }

        // Check if the book is already in the cart using a simple for-loop
        CartItems existingCartItem = null;
        for (CartItems item : cart.getCartItems()) {
            if (item.getBook().getId() == (book.getId())) {
                existingCartItem = item;
                break;
            }
        }

        if (existingCartItem != null) {
            // If found, update quantity and price
            int newQuantity = existingCartItem.getQuantity() + requestedQty;
            if (newQuantity > currentStock + existingCartItem.getQuantity()) {
                throw new RuntimeException("Not enough stock available to increase quantity");
            }

            existingCartItem.setQuantity(newQuantity);
            existingCartItem.setPrice(newQuantity * book.getPrice());

            // Deduct stock based on additional quantity added
            book.setStock(currentStock - requestedQty);
            bookRepository.save(book);

            CartItems updatedItem = cartItemRepository.save(existingCartItem);
            return ResponseEntity.ok(updatedItem);

        } else {
            // If not found, create new cart item
            CartItems cartItem = new CartItems();
            cartItem.setCart(cart);
            cartItem.setBook(book);
            cartItem.setQuantity(requestedQty);
            cartItem.setPrice(requestedQty * book.getPrice());

            // Deduct stock
            book.setStock(currentStock - requestedQty);
            bookRepository.save(book);

            CartItems savedItem = cartItemRepository.save(cartItem);
            return ResponseEntity.ok(savedItem);
        }
    }


    @PutMapping("/updateQuantity")
    public CartItems updateQuantity(@RequestBody CartItemRequest request, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        CartItems cartItem = cartItemRepository.findById(request.getCartItemId())
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        // Check if the cart item belongs to the logged-in user
        if (!userId.equals(cartItem.getCart().getUser().getId())) {
            throw new RuntimeException("Unauthorized");
        }

        int oldQuantity = cartItem.getQuantity();
        int newQuantity = request.getQuantity();

        int quantityDiff = newQuantity - oldQuantity;

        Book book = cartItem.getBook();
        int currentStock = book.getStock();

        // If increasing quantity, check if stock is sufficient
        if (quantityDiff > 0 && quantityDiff > currentStock) {
            throw new RuntimeException("Not enough stock available");
        }

        // Update stock: reduce or increase based on quantity difference
        book.setStock(currentStock - quantityDiff);
        bookRepository.save(book);

        // Update cart item quantity and total price
        cartItem.setQuantity(newQuantity);
        cartItem.setPrice(newQuantity * book.getPrice());

        return cartItemRepository.save(cartItem);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCartItem(@PathVariable("id") int id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userid");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        CartItems cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        Cart cart = cartItem.getCart();
        if (cart == null) {
            throw new RuntimeException("Cart not associated with this cart item");
        }

        User cartUser = cart.getUser();
        if (cartUser == null) {
            throw new RuntimeException("Cart has no user");
        }

        if (!userId.equals(cartUser.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized deletion attempt");
        }

        // Restore the book stock before removing the cart item
        Book book = cartItem.getBook();
        book.setStock(book.getStock() + cartItem.getQuantity());
        bookRepository.save(book);

        // Delete the cart item
        cartItemRepository.deleteById(id);

        // Return success message
        return ResponseEntity.ok(Map.of("message", "Cart item deleted successfully"));
    }

}
