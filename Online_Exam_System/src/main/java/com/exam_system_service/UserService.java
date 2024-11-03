package com.exam_system_service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface UserService {
    void createUser(SessionFactory sf);
    void updateUser(SessionFactory sf);
    void deleteUser(SessionFactory sf);
    void getUser(SessionFactory sf);
    void getAllUser(SessionFactory sf);
}
