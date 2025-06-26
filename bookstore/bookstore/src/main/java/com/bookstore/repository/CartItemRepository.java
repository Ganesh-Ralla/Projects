package com.bookstore.repository;

import com.bookstore.entity.Cart;
import com.bookstore.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItems, Integer> {

    // Delete all CartItems by Cart entity
    void deleteByCart(Cart cart);



}
