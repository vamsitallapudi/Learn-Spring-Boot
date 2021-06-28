package com.coderefer.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coderefer.entity.Product;
import com.coderefer.utility.HibernateUtil;

public class DeleteObjTest 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = HibernateUtil.getSessionFactory();
    	Session s = HibernateUtil.getSession();
    	Transaction tx = null;
    	try (factory;s) {
    		Product p = new Product();
    		p.setPid(9045);
    		p.setPname("Testing delete");
    		
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
