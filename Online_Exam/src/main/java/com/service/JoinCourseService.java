package com.service;

import org.hibernate.SessionFactory;

public interface JoinCourseService {
    void joincourse(SessionFactory sf);
    void disjoincourse(SessionFactory sf);
}
