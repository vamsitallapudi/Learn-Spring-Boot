package com.coderefer.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	static {
		try {
			  Configuration cfg=new Configuration();
			   StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			   StandardServiceRegistry registry=builder.configure("com/coderefer/cfgs/hibernate.cfg.xml").build();
			   //create SessionFactory
			   factory=cfg.buildSessionFactory(registry);
			//build SessionFactory using registry
			factory=cfg.buildSessionFactory(registry);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
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
