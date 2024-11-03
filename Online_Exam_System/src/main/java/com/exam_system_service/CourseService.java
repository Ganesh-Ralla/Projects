package com.exam_system_service;

import org.hibernate.SessionFactory;

public interface CourseService {
    void createCourse(SessionFactory sf);
    void updateCourse(SessionFactory sf);
    void deleteCourse(SessionFactory sf);
    void getCourse(SessionFactory sf);
    void getAllCourse(SessionFactory sf);
}
