package com.bookstore.controller;

import com.bookstore.entity.Address;
import com.bookstore.entity.User;
import com.bookstore.repository.AddressRepository;
import com.bookstore.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/address")
@CrossOrigin(value = "http://localhost:4200",allowCredentials = "true")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address, HttpSession session){

        Integer id= (Integer) session.getAttribute("userid");
        System.out.println("Current user :" + id);
        if(id==null){
            throw new RuntimeException("User not logged in");
        }
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        address.setUser(user);
        return addressRepository.save(address);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Address>> getAddress(HttpSession session) {
        Integer id = (Integer) session.getAttribute("userid");

        if (id == null) {
            throw new RuntimeException("User not logged in");
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Address> addresses = addressRepository.findByUser(user);

        return ResponseEntity.ok(addresses);
    }


}
