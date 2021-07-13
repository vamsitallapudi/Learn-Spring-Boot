package com.coderefer.demo;

import com.coderefer.entity.MobilePhoneUser;
import com.coderefer.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ObjectVersioningInsertTest {
    public static void main(String[] args) {
//        create SessionFactory, Session objs

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = HibernateUtil.getSession();
        Transaction tx= null;
        try(factory;sess) {

            tx =sess.beginTransaction();
            MobilePhoneUser user = new MobilePhoneUser(8686670474L, true, "AP", "Hello Honey Bunny");
            sess.save(user);
            tx.commit();
            System.out.println("Object is saved");
        } catch (HibernateException e) {
            if(tx != null && (tx.getStatus()!=null || tx.getRollbackOnly()))
                tx.rollback();
            e.printStackTrace();
        }
    }
}
