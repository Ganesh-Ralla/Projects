package com.utility;

import com.serviceImpl.*;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {

        SessionFactory sf = Connection.getsFactory();
        Scanner sc = new Scanner(System.in);
        boolean loggedin = false;

        UserServiceImpl user = new UserServiceImpl();
        CourseServiceImpl course = new CourseServiceImpl();
        //course.create_course(sf);
        JoinCourseImpl join = new JoinCourseImpl();
        ExamServiceImpl exam = new ExamServiceImpl();
        //exam.createExam(sf);
        QuestionServiceImpl question = new QuestionServiceImpl();
        //question.createquestions(sf);
        ResultServiceImpl result = new ResultServiceImpl();

        System.out.println("Welcome to the Online Exam System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println(
                    "1. Register\n" +
                    "2. Login\n" +
                    "3. Your Info\n" +
                    "4. Course Details\n" +
                    "5. Attempt an Exam\n" +
                    "6. Check results\n" +
                    "7. Logout\n" +
                    "8. Exit");

            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    user.create_user(sf);
                    break;

                case 2:
                    if (!loggedin) {
                        loggedin = user.login(sf);
                    } else {
                        System.out.println("Already logged in.");
                    }
                    break;

                case 3:
                    if (loggedin) {
                        user.getyour_info(sf);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 4:
                    if (loggedin) {
                        course.getall(sf);
                        System.out.println("1.Join a Course\n2.Disjoin a Course");
                        System.out.print("Your choice :");
                        int op=sc.nextInt();
                        if(op == 1) {
                            join.joincourse(sf);
                        }
                        if(op == 2){
                            join.disjoincourse(sf);
                        }
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 5:
                    if (loggedin) {
                        join.getJoinnedinfo(sf);
                        exam.getExambyId(sf);
                        question.getquestions(sf);

                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;
                case 6:
                    if(loggedin){
                        result.getresult(sf);

                    }else{
                        System.out.println("Please log in first.");
                    }
                    break;

                case 7:
                    if (loggedin) {
                        loggedin = false;
                        System.out.println("Logged out successfully.");
                    } else {
                        System.out.println("You are not logged in.");
                    }
                    break;

                case 8:
                    System.out.print("Exiting");
                    for (int i = 5; i > 0; i--) {
                        System.out.print(".");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
