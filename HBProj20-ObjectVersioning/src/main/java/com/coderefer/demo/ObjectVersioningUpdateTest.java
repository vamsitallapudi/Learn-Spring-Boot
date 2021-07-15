package com.coderefer.demo;

import com.coderefer.entity.MobilePhoneUser;
import com.coderefer.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ObjectVersioningUpdateTest {
    public static void main(String[] args) {
//        create SessionFactory, Session objs

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session sess = HibernateUtil.getSession();
        Transaction tx= null;
        try(factory;sess) {

            tx =sess.beginTransaction();
//            load object
            MobilePhoneUser user = sess.get(MobilePhoneUser.class, 9L);
            if(user != null) {
                user.setCircle("UP");
                sess.update(user);
                tx.commit();
                System.out.println("Object updated for " + user.getUpdationsCount() + " times");
            } else {
                System.out.println("Object Not found for updation");
            }
        } catch (HibernateException e) {
            if(tx != null && (tx.getStatus()!=null || tx.getRollbackOnly()))
                tx.rollback();
            e.printStackTrace();
        }
    }
}
