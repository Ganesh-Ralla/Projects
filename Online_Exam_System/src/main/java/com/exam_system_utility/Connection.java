package com.exam_system_utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory getsFactory() {
        Configuration cfg = new Configuration();
        cfg.configure("config.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        return sf;
    }
}
