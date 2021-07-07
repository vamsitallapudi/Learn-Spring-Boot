//SaveOrUpdateObjectTest1 .java
package com.coderefer.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coderefer.entity.Product;
import com.coderefer.utility.HibernateUtilMySQL;

public class MergeTest_Approach2Problem {

	public static void main(String[] args) {
	   //get SessionFactory obj
		 SessionFactory factory= HibernateUtilMySQL.getSessionFactory();
		 //get Session obj
		 Session ses= HibernateUtilMySQL.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			   tx=ses.beginTransaction();
			       //Load Object
			       Product prod=ses.get(Product.class, 9046);
			       if(prod==null)
			    	   System.out.println("Object not found");
			       else {
			    	   System.out.println("object found::"+prod);
			    	   Product prod1=new Product();
			    	   prod1.setPid(9046);
			    	   prod1.setQty(31.0);
			    	   prod1.setStatus("avaiable");
			    	   ses.update(prod1);
			          tx.commit();
			          System.out.println("Object is  updated");
			       }
		 }//try
		 catch(HibernateException he) {
			 he.printStackTrace();
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true) {
				 tx.rollback();
				 System.out.println("Problem is  saving or updating object");
			 }
		 }

	}//main
}//class
