package com.service;

import org.hibernate.SessionFactory;

public interface ExamService {
    void createExam(SessionFactory sf);
    void getallExam(SessionFactory sf);
    void getExambyId(SessionFactory sf);
}
