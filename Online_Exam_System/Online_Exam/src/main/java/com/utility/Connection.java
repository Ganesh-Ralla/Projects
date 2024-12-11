package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory getsFactory() {

        Configuration cfg = new Configuration();
        cfg.configure("config.xml");

        return cfg.buildSessionFactory();
    }
}

