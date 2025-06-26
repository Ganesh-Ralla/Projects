package com.bookstore.repository;

import com.bookstore.entity.Address;
import com.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    List<Address> findByUser(User user);

    List<Address> findByUserId(Integer userId);

}
