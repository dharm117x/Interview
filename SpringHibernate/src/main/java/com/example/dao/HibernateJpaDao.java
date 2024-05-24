package com.example.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.entity.Country;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@Service
@Transactional(transactionManager = "jpaTransactionManager")
public class HibernateJpaDao {

	@Autowired
	@Qualifier("entityManagerFactory")
    private EntityManagerFactory managerFactory;
	@Autowired
	private Environment env;
	@Autowired EntityManager em;

	public void create(Object object) {
		System.out.println("App :: " + env.getProperty("app"));
		TransactionStatus status=null;
	      try {
	         status = TransactionAspectSupport.currentTransactionStatus();
	      } catch (NoTransactionException e) {
	          System.err.println(e);
	      }
	      System.out.println(status!=null? "active transaction": "no transaction");
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(object);
		transaction.commit();
	}
	
	public void update(Object object) {
		Object merge = em.merge(object);
//		manager.refresh(merge);
		em.persist(merge);	
	}
	
	public List<Country> findAll() {
		return em.createQuery("from Country", Country.class).getResultList();
	}
	
	public Country findOne() {
		return em.find(Country.class, 2);
	}
}
