package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.Exam;
import com.entity_class.User;
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
        exam1.setExamName("Basic java              ");


        Course course2 =s.get(Course.class, 2);
        Exam exam2 = new Exam();
        exam2.setExamId(2);
        exam2.setCourse(course2);
        exam2.setExamName("Basic python            ");

        Course course3 =s.get(Course.class, 3);
        Exam exam3 = new Exam();
        exam3.setExamId(3);
        exam3.setCourse(course3);
        exam3.setExamName("Basic HTML questions    ");

        Course course4 =s.get(Course.class, 4);
        Exam exam4 = new Exam();
        exam4.setExamId(4);
        exam4.setCourse(course4);
        exam4.setExamName("Basic DSA questions     ");

        Course course5 =s.get(Course.class, 5);
        Exam exam5 = new Exam();
        exam5.setExamId(5);
        exam5.setCourse(course5);
        exam5.setExamName("Basic DBMS questions    ");


        s.save(exam1);
        s.save(exam2);
        s.save(exam3);
        s.save(exam4);
        s.save(exam5);
        t.commit();
    }

    @Override
    public void getallExam(SessionFactory sf) {
        s =sf.openSession();
        System.out.print("Enter your id :");
        int uid = sc.nextInt();
        User user = s.get(User.class, uid);

        List<Exam> list = s.createQuery("from Exam ", Exam.class).list();

        // Fetch exams for the user
        //List<Exam> list = s.createQuery("from Exam e where e.user.id = :uid", Exam.class).setParameter("uid", uid).list();


        System.out.println("EXAM_ID\t\t\tEXAM NAME\t\t\t\t\t\t\tCOURSE");
        System.out.println("------------------------------------------------------------------------");
        for (Exam exam : list) {
            String courseName = (exam.getCourse() != null) ? exam.getCourse().getCourseName() : "No Course";
            System.out.println(exam.getExamId() + "\t\t\t" + exam.getExamName() +"\t\t\t" + courseName );
        }
    }
    @Override
    public void getExambyId(SessionFactory sf){
        s = sf.openSession();
        //Course course = new Course();
        System.out.print("Enter course id :");
        int cid = sc.nextInt();

        Course course = s.get(Course.class, cid);

        List<Exam> list = s.createQuery("from Exam e where e.course.courseId = :cid", Exam.class).setParameter("cid", cid).list();
        System.out.println("EXAM_ID\t\t\tEXAM NAME\t\t\t\t\t\t\tCOURSE");
        System.out.println("------------------------------------------------------------------------");
        for (Exam exam : list) {
            String courseName = (exam.getCourse() != null) ? exam.getCourse().getCourseName() : "No Course";
            System.out.println(exam.getExamId() + "\t\t\t" + exam.getExamName() +"\t\t\t" + courseName );
        }

    }
}
