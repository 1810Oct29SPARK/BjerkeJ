package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(HibernateUtil.sessionFactory == null) {
			Configuration c = new Configuration();
			c.setProperty("hibernate.connection.username", System.getenv("DB-username"));
			c.setProperty("hibernate.connection.password", System.getenv("DB-password"));
			c.setProperty("hibernate.connection.url", System.getenv("DB-URL"));
			c.configure();
			HibernateUtil.sessionFactory = c.buildSessionFactory();
		}
		return HibernateUtil.sessionFactory;
	}

}
