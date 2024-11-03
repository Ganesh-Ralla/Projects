package com.exam_system_service_impl;

import com.exam_system_entity.User;
import com.exam_system_service.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner sc= new Scanner(System.in);
    Session s;
    Transaction t;
    User user = new User();
    @Override
    public void createUser(SessionFactory sf) {
        System.out.println("You are a 1.Student\n2.Admin");
        int info_id=sc.nextInt();
        if(info_id == 1) {
            sf.openSession();
            user.setRole(User.Role.STUDENT);
            System.out.print("Enter username :");
            user.setUsername(sc.next());
            System.out.print("Enter your password :");
            user.setPassword(sc.next());
            s.saveOrUpdate(user);
            t.commit();
            System.out.println("Student User Created successfully...");
            System.out.print("your user id is " + user.getUserId());
        }
        if(info_id == 2){
            sf.openSession();
            user.setRole(User.Role.ADMIN);
            System.out.print("Enter username :");
            user.setUsername(sc.next());
            System.out.print("Enter your password :");
            user.setPassword(sc.next());
            s.saveOrUpdate(user);
            t.commit();
            System.out.println("Admin User Created successfully...");
            System.out.print("your user id is " + user.getUserId());
        }
    }

    @Override
    public void updateUser(SessionFactory sf) {
        sf.openSession();
        System.out.println("Before updating mention you are a 1.Student\n2.Admin");
        int info_id=sc.nextInt();
        if(info_id == 1) {
            System.out.print("Enter user id :");
            int uid = sc.nextInt();
            User user = s.get(User.class, uid);
            System.out.println("What you want to change \n1.username\n2.password\n3.both");
            if (uid == 1) {
                System.out.print("Enter new username :");
                user.setUsername(sc.next());
            } else if (uid == 2) {
                System.out.print("Enter your new password :");
                user.setPassword(sc.next());
            } else if (uid == 3) {
                System.out.print("Enter new username :");
                user.setUsername(sc.next());
                System.out.print("Enter your new password :");
                user.setPassword(sc.next());
            }
            s.saveOrUpdate(user);
            t.commit();
            System.out.println("User Updated successfully...");
        }
        if(info_id == 2){
            System.out.print("Enter user id :");
            int uid = sc.nextInt();
            User user = s.get(User.class, uid);
            System.out.println("What you want to change \n1.username\n2.password\n3.both");
            if (uid == 1) {
                System.out.print("Enter new username :");
                user.setUsername(sc.next());
            } else if (uid == 2) {
                System.out.print("Enter your new password :");
                user.setPassword(sc.next());
            } else if (uid == 3) {
                System.out.print("Enter new username :");
                user.setUsername(sc.next());
                System.out.print("Enter your new password :");
                user.setPassword(sc.next());
            }
            s.saveOrUpdate(user);
            t.commit();
            System.out.println("User Updated successfully...");
        }

    }

    @Override
    public void deleteUser(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter user id");
        int id=sc.nextInt();
        User user = s.get(User.class,id);
        if(user != null){
            s.delete(user);
            System.out.println("User deleted successfully");
        }
        else{
            System.out.println("No user found");
        }

    }

    @Override
    public void getUser(SessionFactory sf) {
        sf.openSession();
        System.out.println("Enter user id");
        int id=sc.nextInt();
        if(user != null){
            System.out.println(user);
        }
        else{
            System.out.println("User not found");
        }
    }

    @Override
    public void getAllUser(SessionFactory sf) {
        s= sf.openSession();
        List<User> list = s.createQuery("from user", User.class).list();
        for(User user : list){
            System.out.println(list);
        }
    }
}
