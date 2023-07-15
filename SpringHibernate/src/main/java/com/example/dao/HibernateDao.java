package com.example.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional(transactionManager = "hibernateTransactionManager")
public class HibernateDao {

	@Autowired
	@Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
	@Autowired
	private Environment env;
	
	
	public void create(Object object) {
		System.out.println("App :: " + env.getProperty("app"));
		TransactionStatus status=null;
	      try {
	         status = TransactionAspectSupport.currentTransactionStatus();
	      } catch (NoTransactionException e) {
	          System.err.println(e);
	      }
	      System.out.println(status!=null? "active transaction": "no transaction");

		
		Session session = sessionFactory.getCurrentSession();
		session.save(object);
//		session.close();
	}
	
	public void update(Object object) {
		Session session = sessionFactory.getCurrentSession();
		session.update(object);	
	}
}
