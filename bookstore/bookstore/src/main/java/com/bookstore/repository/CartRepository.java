package com.bookstore.repository;

import com.bookstore.entity.Cart;
import com.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByUser(User user);

    Optional<Cart> findByUser_Id(int userId);
}
