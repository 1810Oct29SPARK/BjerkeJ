package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.beans.Cave;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		try(SessionFactory sf = HibernateUtil.getSessionFactory()){
			Session s = sf.getCurrentSession();
			System.out.println(s.toString());
			s.beginTransaction();
			Cave c = (Cave) s.get(Cave.class, 2);
			System.out.println(c);
			s.close();
		}

	}

}
