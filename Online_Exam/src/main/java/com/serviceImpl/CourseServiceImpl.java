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
        course1.setCourseName("Java Programming");
        course1.setDuration("4 months");

        Course course2 = new Course();
        course2.setCourseId(2);
        course2.setCourseName("Python Programming");
        course2.setDuration("4 months");

        s.save(course1);
        s.save(course2);
        t.commit();
    }

    @Override
    public void getall(SessionFactory sf) {
        s= sf.openSession();
        List<Course> list = s.createQuery("from Course", Course.class).list();
        System.out.println("id\t\tcourse\t\t\tduration");
        System.out.println("-----------------------------");
        for (Course course : list) {
            System.out.println(course.getCourseId()+"\t"+course.getCourseName()+"\t"+ course.getDuration());
        }

    }
}
