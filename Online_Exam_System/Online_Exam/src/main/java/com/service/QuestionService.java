package com.service;

import org.hibernate.SessionFactory;

public interface QuestionService {
    void createquestions(SessionFactory sf);
    void getquestions(SessionFactory sf);

}
