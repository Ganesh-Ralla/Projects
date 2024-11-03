package com.exam_system_service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface QuestionService {
    void createQuestion(SessionFactory sf);
    void updateQuestion(SessionFactory sf);
    void deleteQuestion(SessionFactory sf);
    void getQuestion(SessionFactory sf);
    void getAllQuestion(SessionFactory sf);
}
