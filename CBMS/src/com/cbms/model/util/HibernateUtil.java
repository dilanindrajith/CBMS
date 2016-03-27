package com.cbms.model.util;

/**
 * PRODUCT        : CBMS
 * FUNCTION       : WebFilter
 * AUTHOR         : Dilan Indrajith
 * CREATED DATE   : February 2016
 * VERSION        : 1.0
 * REMARKS        :  
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
		// Optional Code
	}

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {

				Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
				StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
				sb.applySettings(cfg.getProperties());
				StandardServiceRegistry standardServiceRegistry = sb.build();
				sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);

			} catch (Throwable th) {
				System.err.println("SessionFactory creation failed" + th);
				throw new ExceptionInInitializerError(th);
			}
		}
		return sessionFactory;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
