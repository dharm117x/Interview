package com.example.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
@Transactional(transactionManager = "jpaTransactionManager")
public class HibernateJpaDao {

	@Autowired
	@Qualifier("entityManagerFactory")
    private EntityManagerFactory managerFactory;
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
		
		EntityManager em = managerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
		em.persist(object);
//		transaction.commit();
	}
	
	public void update(Object object) {
		EntityManager manager = managerFactory.createEntityManager();
		
		Object merge = manager.merge(object);
//		manager.refresh(merge);
		manager.persist(merge);	
	}
	
	public List findAll() {
		EntityManager manager = managerFactory.createEntityManager();
		return manager.createQuery("from Country").getResultList();
	}
}
