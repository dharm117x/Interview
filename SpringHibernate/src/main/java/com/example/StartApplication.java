package com.example;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.config.AppConfig;
import com.example.dao.HibernateDao;
import com.example.dao.HibernateJpaDao;
import com.example.entity.Country;
@Configuration
@Transactional
@EnableTransactionManagement
public class StartApplication {
public static void main(String[] args) throws InterruptedException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);

		
	System.out.println("Context " + context);
	
//	hibernate(context);
	
	System.out.println("-----------------------JPA------------");
	
	jpa(context);
	
	context.close();
}

private static void hibernate(AbstractApplicationContext context) {
	HibernateDao hibernateDao = context.getBean(HibernateDao.class);
	Country c = new Country();
	c.setName("India");
	c.setLanguage("Hindi");
	c.setCurrency("RS");
	
	hibernateDao.create(c);
	
	c.setName("America");
	hibernateDao.update(c);
	
}


private static void jpa(AbstractApplicationContext context) {
	HibernateJpaDao jpaDao = context.getBean(HibernateJpaDao.class);
	
	Country c1 = new Country();
	c1.setName("Maleshia");
	c1.setLanguage("Hindi");
	c1.setCurrency("RS");
	
	jpaDao.create(c1);
	c1.setName("Australia");
	jpaDao.update(c1);
	
	List findAll = jpaDao.findAll();
	System.out.println(findAll);
}


}
