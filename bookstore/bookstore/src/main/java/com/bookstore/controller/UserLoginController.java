package com.bookstore.controller;

import com.bookstore.entity.User;
import com.bookstore.request.UserLogin;
import com.bookstore.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "http://localhost:4200" , allowCredentials = "true")
public class UserLoginController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody UserLogin userLogin, HttpSession session){

        Optional<User> userOptional = userRepository.findByEmail(userLogin.getEmail());

        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword().equals(userLogin.getPassword())){
                session.setAttribute("user", user);
                session.setAttribute("userid", user.getId());
                Map<String, String> response= new HashMap<>();
                response.put("message", "Login successful");
                response.put("user","Hello "+user.getName());
                return ResponseEntity.ok(response);
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","Invalid password"));
            }
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message","User not found"));
        }
    }

    @GetMapping("/check-login")
    public ResponseEntity<Map<String, String>> checkLoginStatus(HttpSession session) {
        Integer user = (Integer) session.getAttribute("userid");

        Map<String, String> response = new HashMap<>();
        if (user != null) {
            response.put("message", "You already logged in");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "User not logged in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String> > logout(HttpSession session){
        session.invalidate();
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logged out");
        return ResponseEntity.ok(response);
    }
}
