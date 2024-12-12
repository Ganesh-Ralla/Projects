package com.serviceImpl;

import com.entity_class.Course;
import com.service.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    Session s;
    Transaction t;
    @Override
    public void create_course(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        Course course1 = new Course();
        course1.setCourseId(1);
        course1.setCourseName("Java Programming        ");
        course1.setDuration("4 months  ");
        course1.setTrainer("Chaitanya Poighal");

        Course course2 = new Course();
        course2.setCourseId(2);
        course2.setCourseName("Python Programming      ");
        course2.setDuration("4 months  ");
        course2.setTrainer("Abhishek");

        Course course3 = new Course();
        course3.setCourseId(3);
        course3.setCourseName("Web Technologies        ");
        course3.setDuration("3 months  ");
        course3.setTrainer("Shravani");

        Course course4 = new Course();
        course4.setCourseId(4);
        course4.setCourseName("Data Structures         ");
        course4.setDuration("5 months  ");
        course4.setTrainer("Ajay kumar");

        Course course5 = new Course();
        course5.setCourseId(5);
        course5.setCourseName("Database : DBMS(MySQL)  ");
        course5.setDuration("2 months  ");
        course5.setTrainer("Raj kumar");


        s.save(course1);
        s.save(course2);
        s.save(course3);
        s.save(course4);
        s.save(course5);
        t.commit();
    }

    @Override
    public void getall(SessionFactory sf) {
        s= sf.openSession();
        List<Course> list = s.createQuery("from Course", Course.class).list();
        System.out.println("Available Courses");
        System.out.println("Id\t\t\tCourse\t\t\t\t\t\tDuration\t\tTrainer");
        System.out.println("----------------------------------------------------------------------------");
        for (Course course : list) {
            System.out.println(course.getCourseId()+"\t\t"+course.getCourseName()+"\t\t"+ course.getDuration()+"\t\t"+course.getTrainer());
        }

    }
}
