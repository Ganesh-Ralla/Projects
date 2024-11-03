package com.exam_system_service_impl;

import com.exam_system_entity.Course;
import com.exam_system_entity.JoinCourse;
import com.exam_system_entity.User;
import com.exam_system_service.JoinCourseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class JoinCourseServiceImpl implements JoinCourseService {
    Session s;
    Transaction t;
    Scanner sc = new Scanner(System.in);
    @Override
    public void createjoincourse(SessionFactory sf) {
        sf.openSession();
        System.out.print("Enter your id :");
        Long uid=sc.nextLong();
        System.out.print("Enter course id :");
        Long id =sc.nextLong();
        User user = s.get(User.class, id);
        Course course = s.get(Course.class, id);
        if (user != null && course != null) {
            JoinCourse joinCourse = new JoinCourse();
            joinCourse.setUser(user);
            joinCourse.setCourse(course);

            s.save(joinCourse);
            System.out.println("User joined the course successfully.");
        }
        else {
                System.out.println("User or course not found.");
        }
        t.commit();
    }

    @Override
    public void updatejoincourse(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter your id ");
        int uid= (int) sc.nextLong();
        System.out.println("Enter course id");
        Long id =sc.nextLong();
        User user = s.get(User.class, id);
        Course course = s.get(Course.class, id);
        if (user != null && course != null) {
            JoinCourse joinCourse = new JoinCourse();
            joinCourse.setUser(user);
            joinCourse.setCourse(course);

            s.saveOrUpdate(joinCourse); // Save the joinCourse entry
            System.out.println("User joined the course successfully.");
        }
        else {
            System.out.println("User or course not found.");
        }
        t.commit();

    }

    @Override
    public void deletejoincourse(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter your id");
        int id = sc.nextInt();
        System.out.println("Enter join id to drop from the course");
        int jid=sc.nextInt();
        User user=s.get(User.class, id);
        JoinCourse joinCourse=s.get(JoinCourse.class, jid);

        if (user != null && joinCourse != null) {
            // Verify if the joinCourse belongs to the user
            if (joinCourse.getUser().getUserId().equals(id)) {
                s.delete(joinCourse); // Delete the joinCourse entry
                System.out.println("User dropped out from the course successfully.");
            } else {
                System.out.println("This join record does not belong to the user.");
            }
        } else {
            System.out.println("User or join record not found.");
        }
        t.commit();

    }

    @Override
    public void get(SessionFactory sf) {
        sf.openSession();
        System.out.print("Enter user id :");
        int uid=sc.nextInt();
        System.out.print("Enter cours id :");
        int cid=sc.nextInt();
        JoinCourse joinCourse = new JoinCourse();
        User user=s.get(User.class, uid);
        Course course=s.get(Course.class, cid);
        if(user != null && course != null){
            System.out.println(joinCourse);
        }
        else{
            System.out.println("No user found with the mentioned course");
        }
    }
    @Override
    public void getAll(SessionFactory sf) {
        sf.openSession();
        List<JoinCourse> list = s.createQuery("from joincourse", JoinCourse.class).list();
        for(JoinCourse joinCourse : list){
            System.out.println(list);
        }

    }
}
