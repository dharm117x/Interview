package com.example;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.config.AppConfig;
import com.example.dao.HibernateDao;
import com.example.dao.HibernateJpaDao;
import com.example.entity.Country;

import jakarta.transaction.Transactional;
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
	c1.setName("Japan");
	c1.setLanguage("japanis");
	c1.setCurrency("YEN");
	
	Country c2 = new Country();
	c2.setName("India");
	c2.setLanguage("Hindi");
	c2.setCurrency("RS");
	
	jpaDao.create(c1);
	jpaDao.create(c2);
	
	c1.setName("Australia");
	jpaDao.update(c1);
	
	List<Country> findAll = jpaDao.findAll();
	System.out.println(findAll);
	
	Country findOne = jpaDao.findOne();
	System.out.println(findOne);
}


}
