package com.exam_system_service;

import org.hibernate.SessionFactory;

public interface UserExamsService {
    void addUserExams(SessionFactory sf);
    void updateUserExams(SessionFactory sf);
    void deleteUserExams(SessionFactory sf);
    void getUserExams(SessionFactory sf);
    void getAll(SessionFactory sf);
}
