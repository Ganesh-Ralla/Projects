package com.exam_system_service_impl;

import com.exam_system_entity.Course;
import com.exam_system_entity.Exam;
import com.exam_system_service.ExamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class ExamServiceImpl implements ExamService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;
    @Override
    public void insertExam(SessionFactory sf) {
        sf.openSession();
        Course course = new Course();

        Exam exam1 = new Exam();
        exam1.setExamId(1);
        exam1.setCourse(course);
        exam1.setExamName("Java basic questions");

        Exam exam2 = new Exam();
        exam2.setExamId(1);
        exam2.setCourse(course);
        exam2.setExamName("Python basic questions");

        Exam exam3 = new Exam();
        exam3.setExamId(1);
        exam3.setCourse(course);
        exam3.setExamName("DSA basic questions");


        s.save(exam1);
        s.save(exam2);
        s.save(exam3);

        t.commit();
    }

    @Override
    public void updateExam(SessionFactory sf) {
        System.out.println("Enter exam id to update");
        int eid=sc.nextInt();

        Exam exam = s.get(Exam.class, eid);
        if(exam != null){
            Exam exam1 = new Exam();
            System.out.println("Enter the updated exam name");
            exam1.setExamName(sc.next());
            s.saveOrUpdate(exam1);
        }
        t.commit();
    }

    @Override
    public void deleteExam(SessionFactory sf) {
        sf.openSession();
        System.out.print("Enter exam id to delete :");
        int eid=sc.nextInt();
        Exam exam = s.get(Exam.class, eid);
        if(exam != null){
            s.delete(exam);
            System.out.println("Exam deleted successfully");
        }
        else{
            System.out.println("No exam found with the given id");
        }
        t.commit();
    }

    @Override
    public void getExam(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter exam id to view questions");
        int eid=sc.nextInt();
        Exam exam =s.get(Exam.class, eid);
        if(exam != null){
            System.out.println(exam);
        }
        else {
            System.out.println("No exam found with the given id");
        }

    }

    @Override
    public void getAllExam(SessionFactory sf) {
        sf.openSession();
        List<Exam> list = s.createQuery("from exam", Exam.class).list();
        for(Exam exam : list){
            System.out.println(list);
        }

    }
}
