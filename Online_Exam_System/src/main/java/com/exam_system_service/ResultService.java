package com.exam_system_service;

import org.hibernate.SessionFactory;

public interface ResultService {
    void createResults(SessionFactory sf);
    void updateResults(SessionFactory sf);
    void deleteResults(SessionFactory sf);
    void getResult(SessionFactory sf);
    void getAll(SessionFactory sf);
}
