package com.exam_system_service;

import org.hibernate.SessionFactory;

public interface JoinCourseService {
    void createjoincourse(SessionFactory sf);
    void updatejoincourse(SessionFactory sf);
    void deletejoincourse(SessionFactory sf);
    void get(SessionFactory sf);
    void getAll(SessionFactory sf);
}
