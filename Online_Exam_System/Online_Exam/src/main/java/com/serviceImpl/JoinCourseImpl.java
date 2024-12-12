package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.Exam;
import com.entity_class.JoinCourse;
import com.entity_class.User;
import com.exceptions.CourseNotFoundException;
import com.exceptions.UserNotFoundException;
import com.service.JoinCourseService;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class JoinCourseImpl implements JoinCourseService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;

    @Override
    public void joincourse(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        System.out.print("Enter your id :");
        int uid = sc.nextInt();
        System.out.print("Enter course id :");
        int cid = sc.nextInt();

        User user = s.get(User.class, uid);
        Course course = s.get(Course.class, cid);

        if (user != null && course != null) {
            JoinCourse join = new JoinCourse();
            join.setUser(user);
            join.setCourse(course);

            s.save(join);
            System.out.println("\nYou joined in " + course.getCourseName());
        } else {
            try {
                throw new CourseNotFoundException("No Course found with the id " + cid);
            } catch (CourseNotFoundException e) {
                System.out.println("Course not found exception");
            }
            try {
                throw new UserNotFoundException("No user found with ID: " + uid);
            } catch (UserNotFoundException e) {
                System.out.println("User not found exception");
            }
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

        List<Course> courses = s.createQuery(
                        "select jc.course from JoinCourse jc where jc.user.userId = :userId", Course.class)
                .setParameter("userId", uid)
                .getResultList();

        if (courses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            System.out.println("You are enrolled in the following courses:");
            System.out.println("COURSE ID\tCOURSE NAME\tDURATION");
            System.out.println("----------------------------------------");
            for (Course course : courses) {
                System.out.println(course.getCourseId() + course.getCourseName() + course.getDuration());
            }

            System.out.print("Enter course id to drop from: ");
            int cid = sc.nextInt();

            Course course = s.get(Course.class, cid);

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
                try {
                    throw new CourseNotFoundException("No Course found with the id " + cid);
                } catch (CourseNotFoundException e) {
                    System.out.println("Course not found exception");
                }
                try {
                    throw new UserNotFoundException("No user found with ID: " + uid);
                } catch (UserNotFoundException e) {
                    System.out.println("User not found exception");
                }
                System.out.println("User or Course not found");
                System.out.println("You are not enrolled in this course.");
            }
            s.close();
        }

    }

    @Override
    public void getJoinnedinfo(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        System.out.print("Enter your id: ");
        int uid = sc.nextInt();

        Course course = new Course();
        List<JoinCourse> joinCourses = s.createQuery(
                        "from JoinCourse jc where jc.user.userId = :userId", JoinCourse.class)
                .setParameter("userId", uid).list();
        if (joinCourses.isEmpty()) {
            System.out.println("You are not enrolled in any courses.");
        } else {
            System.out.println("Your enrolled courses:");
            System.out.println("COURSE ID\t\t\tCOURSE NAME\t\tUSER NAME");
            System.out.println("-----------------------------------------------");
            for (JoinCourse join : joinCourses) {
                System.out.printf(join.getCourse().getCourseId() + "\t" + join.getCourse().getCourseName() + "\t"+ join.getUser().getUsername()+"\n");
            }
        }
    }
}