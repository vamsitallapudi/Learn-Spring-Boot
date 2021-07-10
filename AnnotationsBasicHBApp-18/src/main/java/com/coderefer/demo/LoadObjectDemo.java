package com.coderefer.demo;

import com.coderefer.entity.Artist;
import com.coderefer.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadObjectDemo {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = HibernateUtil.getSession();
        try(factory;sess) {
            Artist artist = sess.load(Artist.class, 1236);
//            System.out.println(artist);
        } catch (HibernateException e) {
            System.out.println("Problem in loading Record");
            e.printStackTrace();
        }
    }
}
