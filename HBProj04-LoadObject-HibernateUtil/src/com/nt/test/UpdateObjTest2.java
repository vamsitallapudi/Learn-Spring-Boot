package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjTest2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		try (factory;sess) {
//			Load object
			Product p = sess.get(Product.class, 9045);
			if(p==null) {
				System.out.println("record not found");
				return;
			} else {
//				Begin Tx
				tx = sess.beginTransaction();
				p.setPrice(930.0);
				sess.update(p);
				tx.commit();
				System.out.println("Object found and updated");
			}
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
