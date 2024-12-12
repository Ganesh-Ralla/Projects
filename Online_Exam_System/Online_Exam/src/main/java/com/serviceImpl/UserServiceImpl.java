package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.JoinCourse;
import com.entity_class.User;
import com.exceptions.UserNotFoundException;
import com.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;
    @Override
    public void create_user(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        User user = new User();
        System.out.print("Enter your full name : ");
        user.setFullname(sc.next());
        System.out.print("Enter your email : ");
        user.setEmail(sc.next());
        System.out.print("Enter your name or username : ");
        user.setUsername(sc.next());
        System.out.print("Enter your password : ");
        user.setPassword(sc.next());
        s.save(user);
        t.commit();
        System.out.println("User created successfully\nYour id is : "+user.getUserId());
    }

    @Override
    public void update_user(SessionFactory sf) {
        s= sf.openSession();
        t=s.beginTransaction();
        System.out.print("Enter user id : ");
        int uid = sc.nextInt();
        User user = s.get(User.class, uid);
        if(user == null){
            try {
                throw new UserNotFoundException("No user found with ID: " + uid);
            } catch (UserNotFoundException e) {
                System.out.println("User not found exception");
            }
        }
        else {
            System.out.println("What you want to change \n1.Name\n2.Username\n3.Password\n4.Email");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter new full name : ");
                user.setFullname(sc.next());
            } else if (choice == 2) {
                System.out.print("Enter your new username : ");
                user.setUsername(sc.next());
            } else if (choice == 3) {
                System.out.print("Enter new password : ");
                user.setPassword(sc.next());
            } else if (choice == 4) {
                System.out.print("Enter your new email : ");
                user.setEmail(sc.next());
            }
        }
        s.saveOrUpdate(user);
        t.commit();
        System.out.println("User Updated successfully...");
    }

    @Override
    public void delete_user(SessionFactory sf) {
        s= sf.openSession();
        t=s.beginTransaction();
        System.out.println("Enter user id");
        int id=sc.nextInt();
        User user = s.get(User.class,id);
        if(user != null){
            s.delete(user);
            System.out.println("User deleted successfully");
        }
        else{
            try {
                throw new UserNotFoundException("No user found with ID: " + id);
            } catch (UserNotFoundException e) {
                System.out.println("User not found exception");
            }
        }

    }

    @Override
    public void getyour_info(SessionFactory sf) {
        s= sf.openSession();
        t=s.beginTransaction();
        System.out.print("Enter user id : ");
        int id=sc.nextInt();
        User user = s.get(User.class, id);
        JoinCourse join = new JoinCourse();
        if(user == null){
            try {
                throw new UserNotFoundException("No user found with ID: " + id);
            } catch (UserNotFoundException e) {
                System.out.println("User not found exception");
            }
        }
        if(user != null){

            System.out.println("User name \t: "+user.getFullname()+
                    "\nUsername \t: "+user.getUsername()+
                    "\nUser id \t: "+user.getUserId()+
                    "\nEmail \t\t: "+user.getEmail()+
                    "\npassword \t: "+user.getPassword());

//            List<JoinCourse> join1 = s.createQuery(" select jc.coursename from JoinCourse where user.userId = :userId", JoinCourse.class)
//                    .setParameter("userId", user.getUserId()).list();
//            System.out.println("You joined in " + join1);

            System.out.println("Do you want to change or update your info\n0.Yes or 1.No");
            int op=sc.nextInt();
            if(op==0){
                System.out.print("What you want to do \n1.Update details\n2.Delete your account\n");
                int choice=sc.nextInt();
                if(choice==1){
                    update_user(sf);
                }
                else{
                    delete_user(sf);
                }
            }
        }
        else{
            System.out.println("User not found");
        }
    }

    @Override
    public boolean login(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        System.out.print("Enter username : ");
        String uname=sc.next();
        System.out.print("Enter password : ");
        String  upassword=sc.next();

        User user = s.createQuery("FROM User WHERE username = :username", User.class).setParameter("username", uname).uniqueResult();

        if (user != null && upassword.equals(user.getPassword())) {
            System.out.println("Login successful.");

            return true;

        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
