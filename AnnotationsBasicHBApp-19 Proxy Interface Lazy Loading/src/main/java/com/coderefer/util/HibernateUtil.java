package com.coderefer.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    static {
        try {
            Configuration cfg = new Configuration();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            StandardServiceRegistry registry = builder.configure("hibernate.cfg.xml").build();
//        create session factory
            factory = cfg.buildSessionFactory(registry);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }
    public static Session getSession() {
        Session sess = null;
        if(factory != null) {
            sess = factory.openSession();
        }
        return sess;
    }

    public static void closeSession(Session session) {
        if(session != null) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        if(factory != null) {
            factory.close();
        }
    }


}