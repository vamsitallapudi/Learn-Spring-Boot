package com.coderefer.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coderefer.entity.Product;
import com.coderefer.utility.HibernateUtil;

public class DeleteObjTest2 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session s = HibernateUtil.getSession();
    	Transaction tx = null;
    	try (factory;s) {
    		Product p = s.get(Product.class, 9045);
    		if(p == null) {
    			System.out.println("No record found to delete");
    			return;
    		}
//    		begin tx
    		tx = s.beginTransaction();
    		s.delete(p);
    		tx.commit();
    		System.out.println("Product Deleted");
    	} catch(HibernateException e) {
    		if(tx!=null && tx.getStatus()!= null && tx.getRollbackOnly()) {
    			tx.rollback();
    		}
    		System.out.println("Object not deleted.");
    	}
    }
}
