package com.exam_system_service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface OptionsService {
    void createOption(SessionFactory sf);
    void updateOption(SessionFactory sf);
    void deleteOption(SessionFactory sf);
    void getOption(SessionFactory sf);
    void getAll(SessionFactory sf);
}
