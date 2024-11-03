package com.exam_system_service;


import org.hibernate.SessionFactory;

public interface ExamService {
    void insertExam(SessionFactory sf);
    void updateExam(SessionFactory sf);
    void deleteExam(SessionFactory sf);
    void getExam(SessionFactory sf);
    void getAllExam(SessionFactory sf);
}
