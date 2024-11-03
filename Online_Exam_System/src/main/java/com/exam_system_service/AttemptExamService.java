package com.exam_system_service;

import org.hibernate.SessionFactory;

public interface AttemptExamService {
    void attemptExam(SessionFactory sf);
    void updateAttemptExam(SessionFactory sf);
    void deleteAttemptExam(SessionFactory sf);
    void getAttemptExam(SessionFactory sf);
    void getAllAttemptExam(SessionFactory sf);
}
