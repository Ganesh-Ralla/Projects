package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.JoinCourse;
import com.entity_class.User;
import com.service.JoinCourseService;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class JoinCourseImpl implements JoinCourseService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;
    @Override
    public void joincourse(SessionFactory sf) {
         s= sf.openSession();
         t=s.beginTransaction();
        System.out.print("Enter your id :");
        int uid=sc.nextInt();
        System.out.print("Enter course id :");
        int cid=sc.nextInt();

        User user = s.get(User.class, uid);
        Course course = s.get(Course.class, cid);

        if(user != null && course != null){
            JoinCourse join = new JoinCourse();
            join.setUser(user);
            join.setCourse(course);

            s.save(join);
            System.out.println("You joined in "+ course.getCourseName() +" course successfully..");
        }
        else{
            System.out.println("User or Course not found");
        }
        s.close();
    }

    @Override
    public void disjoincourse(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();

        System.out.print("Enter your id: ");
        int uid = sc.nextInt();
        System.out.print("Enter course id to drop from: ");
        int cid = sc.nextInt();


        JoinCourse joinRecord = (JoinCourse) s.createQuery(
                        "from JoinCourse jc where jc.user.userId = :userId and jc.course.courseId = :courseId")
                .setParameter("userId", uid)
                .setParameter("courseId", cid)
                .uniqueResult();

        if (joinRecord != null) {
            s.delete(joinRecord);
            t.commit();
            System.out.println("User dropped out from the course successfully.");
        } else {
            System.out.println("You are not enrolled in this course.");
        }
        s.close();
    }

}
