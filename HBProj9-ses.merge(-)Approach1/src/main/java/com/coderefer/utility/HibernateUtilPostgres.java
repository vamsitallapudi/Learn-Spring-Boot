package com.coderefer.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilPostgres {
	private static SessionFactory factory;
	static {
		try {
		//Actiate  hibernate
		Configuration cfg=new Configuration();
		cfg.configure("/com/coderefer/cfgs/hibernate-postgres.cfg.xml");
		//build SessionFactory
		 factory=cfg.buildSessionFactory();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	 public  static  SessionFactory getSessionFactory() {
             return factory;
	 }
	 public  static   Session  getSession() {
		 Session ses=null;
		   if(factory!=null)
			   ses=factory.openSession();
		   return ses;
	 }
	 
	 public static void closeSession(Session ses) {
		  if(ses!=null)
			  ses.close();
	 }
	 
	 public static void closeSessionFactory() {
		  if(factory!=null)
			  factory.close();
	 }


}
