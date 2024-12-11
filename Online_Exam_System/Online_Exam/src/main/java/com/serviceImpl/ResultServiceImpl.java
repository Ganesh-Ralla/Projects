package com.serviceImpl;

import com.entity_class.*;
import com.service.ResultService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class ResultServiceImpl implements ResultService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;

    @Override
    public void getresult(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();

        System.out.print("Enter user id: ");
        int uid = sc.nextInt();
        User user = s.get(User.class, uid);

        if (user == null) {
            System.out.println("User not found.");
            t.rollback();
            s.close();
            return;
        }

        // HQL query to fetch results
        String query = "SELECT r.exam.examName, r.score FROM Result r WHERE r.user.id = :userId";

        List<Object[]> results = s.createQuery(query).setParameter("userId", uid).list();

        if (results.isEmpty()) {
            System.out.println("No results found for the user.");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("Results for User\t\t\t    : " + user.getFullname());
            System.out.println("--------------------------------------------");
            System.out.println("Exam Name                       :\tScore");
            System.out.println("--------------------------------------------");
            for (Object[] result : results) {
                System.out.println(result[0] + "\t\t:\t" + result[1]+"/5"); // Exam Name and Score
            }
        }

        t.commit();
        s.close();
    }


}

