package com.service;

import org.hibernate.SessionFactory;

public interface ResultService {
    void createresult(SessionFactory sf);
    void getresult(SessionFactory sf);
}
