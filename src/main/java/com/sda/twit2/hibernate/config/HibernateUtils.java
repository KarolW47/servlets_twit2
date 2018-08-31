package com.sda.twit2.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtils {

    private HibernateUtils() {
    }

    private final static SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    private static Session session;

    public static Session getSession() {
        if (session == null){
            session = SESSION_FACTORY.openSession();
        }
        return session;
    }
}
