package com.exam_system_service_impl;

import com.exam_system_entity.AttemptExam;
import com.exam_system_service.AttemptExamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class AttemptExamServiceImpl implements AttemptExamService {

    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;
    AttemptExam attempt = new AttemptExam();

    @Override
    public void attemptExam(SessionFactory sf) {
        attempt.setAttemptId(1);
        //attempt.setExam();

    }

    @Override
    public void updateAttemptExam(SessionFactory sf) {

    }

    @Override
    public void deleteAttemptExam(SessionFactory sf) {

    }

    @Override
    public void getAttemptExam(SessionFactory sf) {

    }

    @Override
    public void getAllAttemptExam(SessionFactory sf) {

    }
}
