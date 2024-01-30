package com.example.ForexApp_v1.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ForexAppSessionFactory {
    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }
}
