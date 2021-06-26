package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}// static
	
	public static SessionFactory getSessionFactory() {
		if(factory != null)
			return factory;
		else
			throw new RuntimeException("Invalid SessionFactory Object Creation");
	}
	
	public static Session getSession() {
		Session sess = null;
		if(factory!=null)
			sess = factory.openSession();
		
		return sess;
	}

}
