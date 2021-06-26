package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		boolean flag = true;
		try (factory;sess) {
//			Prepare object
			Product p = new Product();
			p.setPid(9045);
			p.setPname("FaceCream");
			p.setPrice(900.0);
			p.setQty(2.0);
			p.setStatus("NotAvailable");
//			begin tx
			tx = sess.beginTransaction();
			sess.update(p);
			flag = true;
		} catch(HibernateException e) {
			if(tx != null && tx.getStatus() != null && tx.getRollbackOnly()) {
				tx.rollback();
			}
			flag = false;
			e.printStackTrace();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
	}

}
