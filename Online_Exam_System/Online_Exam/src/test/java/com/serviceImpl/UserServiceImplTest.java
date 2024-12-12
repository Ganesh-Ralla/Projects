package com.serviceImpl;

import com.entity_class.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void create_user() {
        User user = new User(1l,"Ganesh","ganesh@gmail.com","Ganesh","ganesh07");
        assertEquals(1, user.getUserId());
        assertEquals("Ganesh", user.getUsername());
        assertEquals("ganesh@gmail.com", user.getEmail());
        assertEquals("Ganesh", user.getFullname());
        assertEquals("ganesh07", user.getPassword());
    }
}