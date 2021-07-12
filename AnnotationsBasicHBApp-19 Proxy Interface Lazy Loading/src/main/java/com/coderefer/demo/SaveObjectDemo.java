package com.coderefer.demo;

import com.coderefer.entity.Artist;
import com.coderefer.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveObjectDemo {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ses = HibernateUtil.getSession();
        Transaction tx = null;
        try (factory; ses) {
            tx = ses.beginTransaction();

//            Artist artist = new Artist(1235, "Vamsi", "Hyderabad", 98984567L, "Hero");
            Artist artist = new Artist();
            artist.setAid(1239);
            artist.setName("Lava");
            artist.setCategory("God");
            Integer idval = (Integer) ses.save(artist);
            System.out.println("Generated ID Value: " + idval);
            tx.commit();
        } catch (HibernateException e) {
            if(tx!=null && (tx.getRollbackOnly() || tx.getStatus()!= null))
                tx.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
