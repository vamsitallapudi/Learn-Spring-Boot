//SaveOrUpdateObjectTest1 .java
package com.coderefer.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coderefer.entity.Product;
import com.coderefer.utility.HibernateUtilMySQL;

public class MergeTest_Approach1 {

	public static void main(String[] args) {
	   //get SessionFactory obj
		 SessionFactory factory= HibernateUtilMySQL.getSessionFactory();
		 //get Session obj
		 Session ses= HibernateUtilMySQL.getSession();
		 Transaction tx=null;
		 try(factory;ses){
			 //begin Tx
			   tx=ses.beginTransaction();
			      //prepare object
			        Product prod=new Product();
			          prod.setPid(9099);
			          prod.setPname("hanging light");
			          prod.setPrice(21000.0);
			          //prod.setQty(18.0);
			         //prod.setStatus("not avaiable");
			          //save or update object
			             Product p1=(Product) ses.merge(prod);
			             System.out.println(p1);
			          tx.commit();
			          System.out.println("Object is saved or updated");
		 }//try
		 catch(HibernateException he) {
			 if(tx!=null && tx.getStatus()!=null && tx.getRollbackOnly()==true) {
				 tx.rollback();
				 System.out.println("Problem is  saving or updating object");
			 }
		 }

	}//main
}//class
