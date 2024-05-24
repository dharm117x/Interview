package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.Driver;

import jakarta.persistence.EntityManager;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("app.properties")
@ComponentScan(basePackages = "com.example")
public class AppConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.example.entity" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(props());

		return em;
	}

	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().getObject().createEntityManager();
	}
	
//	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public PlatformTransactionManager jpaTransactionManager() {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	    transactionManager.setDataSource(dataSource());
	    return transactionManager;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();
		lsf.setPackagesToScan("com.example.entity");
		lsf.setDataSource(dataSource());

		lsf.setHibernateProperties(props());

		return lsf;

	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource sds = new SimpleDriverDataSource();
		sds.setDriverClass(Driver.class);
		//sds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		sds.setUrl("jdbc:mysql://localhost:3306/hibernatedb");
		sds.setUsername("root");
		sds.setPassword("admin");
		return sds;
	}

	private Properties props() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.generate_statistics", "true");
		props.setProperty("hibernate.cache.use_query_cache", "true");
		
		props.setProperty("hibernate.cache.use_second_level_cache", "true");
		props.setProperty("hibernate.cache.region.factory_class", "jcache");
		props.setProperty("hibernate.javax.cache.provider", "org.ehcache.jsr107.EhcacheCachingProvider");

		//		props.setProperty("hibernate.current_session_context_class", "thread"); // Not with @Transactional
//		props.setProperty("hibernate.transaction.jta.platform", "org.hibernate.engine.transaction.jta.platform.internal.WeblogicJtaPlatform");
//		props.setProperty("hibernate.dialect"  , "org.hibernate.dialect.Oracle10gDialect");
//		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return props;
	}
}
