package com.bookstore.repository;

import com.bookstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findAllByUser_Id(Integer userId);
    Orders findTopByUser_IdOrderByOrderDateDesc(Integer userId);
    List<Orders> findByUserId(Integer userId);


}
