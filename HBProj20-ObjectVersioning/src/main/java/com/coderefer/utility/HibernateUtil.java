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
			Configuration cfg = new Configuration();
			cfg.configure("com/coderefer/cfgs/hibernate.cfg.xml").buildSessionFactory();;
			cfg.addResource("com.coderefer.entity.MobileUser.hbm.xml");
			//create ServiceRegistryBuilder
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			//create Service registry
			StandardServiceRegistry registry=builder.applySettings(cfg.getProperties()).build();
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
