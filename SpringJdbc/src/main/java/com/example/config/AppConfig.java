package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example")
public class AppConfig {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager());
	}
	
	@Bean
	public PlatformTransactionManager  transactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource());
		manager.setValidateExistingTransaction(true);
		return manager;
	}

	@Bean
	protected DataSource dataSource() {
		SimpleDriverDataSource sds = new SimpleDriverDataSource();
		sds.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		sds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		sds.setUsername("projectdb");
		sds.setPassword("admin");
		return sds;
	}

}
