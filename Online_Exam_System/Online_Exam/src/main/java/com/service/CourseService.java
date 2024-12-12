package com.service;

import org.hibernate.SessionFactory;

public interface CourseService {
    void create_course(SessionFactory sf);
    void getall(SessionFactory sf);
}
