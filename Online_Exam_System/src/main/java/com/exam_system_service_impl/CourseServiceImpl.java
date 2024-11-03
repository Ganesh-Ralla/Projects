package com.exam_system_service_impl;

import com.exam_system_entity.Course;
import com.exam_system_entity.User;
import com.exam_system_service.CourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {

    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;
    Course course = new Course();
    @Override
    public void createCourse(SessionFactory sf) {
        Course course1 = new Course();
        course1.setCourseId(1);
        course1.setCourseName("Java");
        course1.setDuration("3months");

        Course course2 = new Course();
        course2.setCourseId(2);
        course2.setCourseName("python");
        course2.setDuration("3months");

        Course course3 = new Course();
        course3.setCourseId(3);
        course3.setCourseName("DSA");
        course3.setDuration("5months");



        s.save(course1);
        s.save(course2);
        s.save(course3);

        t.commit();

    }

    @Override
    public void updateCourse(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter course id to update");
        int cid=sc.nextInt();
        Course course=s.get(Course.class, cid);
        if(course != null){
            System.out.println("What you want to update\n1.Course name\n2.Duration");
            int change=sc.nextInt();
            if(change == 1){
                System.out.print("Enter the new course name to update :");
                course.setCourseName(sc.next());
            } else if (change == 2) {
                System.out.println("Enter the duration time to update");
                course.setDuration(sc.next());
            }
        }
    }

    @Override
    public void deleteCourse(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter course id to delete course");
        long id = sc.nextLong();
        Course course = s.get(Course.class, id);
        if(course != null){
            s.delete(course);
            System.out.println("Course deleted successfully");
        }
        else{
            System.out.println("Course not found");
        }

    }

    @Override
    public void getCourse(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter user id to view a course");
        int id=sc.nextInt();
        Course course = s.get(Course.class, id);
        if(course != null){
            System.out.println(course);
        }
        else{
            System.out.println("User not found");
        }

    }

    @Override
    public void getAllCourse(SessionFactory sf) {
        s= sf.openSession();
        List<Course> list = s.createQuery("from course", Course.class).list();
        for(Course course : list){
            System.out.println(list);
        }
    }
}
