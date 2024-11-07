package com.serviceImpl;

import com.entity_class.Exam;
import com.entity_class.Questions;
import com.entity_class.Result;
import com.entity_class.User;
import com.service.ResultService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class ResultServiceImpl implements ResultService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;

    @Override
    public void createresult(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        Result result = new Result();

        User user = s.get(User.class, 1);
        result.setUser(user);

        Exam exam = s.get(Exam.class, 1);
        result.setExam(exam);

        Questions questions = new Questions();
        result.setScore(questions.getScore());


    }

    @Override
    public void getresult(SessionFactory sf) {

        s = sf.openSession();
        t = s.beginTransaction();
        Result result = new Result();

        System.out.print("Enter your id :");
        int uid = sc.nextInt();
        User user = s.get(User.class,uid );
        result.setUser(user);
        Questions questions = s.get(Questions.class, 1);

        System.out.print("Enter exam id :");
        int eid = sc.nextInt();
        Exam exam = s.get(Exam.class, eid);
        result.setExam(exam);

        System.out.print("Your score in the exam is :"+ result.getScore());

    }
}
