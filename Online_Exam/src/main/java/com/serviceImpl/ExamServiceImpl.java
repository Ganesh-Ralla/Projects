package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.Exam;
import com.service.ExamService;
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
    public void createExam(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();

        Course course1 =s.get(Course.class, 1);
        Exam exam1 = new Exam();
        exam1.setExamId(1);
        exam1.setCourse(course1);
        exam1.setExamName("Basic java ");

        Course course2 =s.get(Course.class, 2);
        Exam exam2 = new Exam();
        exam2.setExamId(2);
        exam2.setCourse(course2);
        exam2.setExamName("Basic python");

        s.save(exam1);
        s.save(exam2);
        t.commit();
    }

    @Override
    public void getallExam(SessionFactory sf) {
        s =sf.openSession();
        List<Exam> list = s.createQuery("from Exam", Exam.class).list();
        System.out.println("EXAM_ID\t\t\tCOURSE\t\t\t\tEXAM NAME");
        System.out.println("-----------------------------------------------");
        for(Exam exam: list){
            String courseName = (exam.getCourse() != null) ? exam.getCourse().getCourseName() : "No Course";
            System.out.println(exam.getExamId()+"\t\t\t"+courseName+"\t\t"+exam.getExamName());
        }
    }
}
