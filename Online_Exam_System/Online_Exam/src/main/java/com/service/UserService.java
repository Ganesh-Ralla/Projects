package com.service;

import org.hibernate.SessionFactory;

public interface UserService {
    void create_user(SessionFactory sf);
    void update_user(SessionFactory sf);
    void delete_user(SessionFactory sf);
    void getyour_info(SessionFactory sf);
    boolean login(SessionFactory sf);

}
