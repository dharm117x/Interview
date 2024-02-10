package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@EnableScheduling
@ComponentScan(basePackages = "com.example")
public class AppConfig {
	
	protected DataSource dataSource() {
		SimpleDriverDataSource sds = new SimpleDriverDataSource();
		sds.setDriverClass(org.h2.Driver.class);
		sds.setUrl("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
		sds.setUsername("sa");
		sds.setPassword("");
		return sds;
	}

	//@Bean("customSchedulerFactoryBean1")
    public SchedulerFactoryBean customSchedulerFactoryBean1(DataSource dataSource) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        Properties properties = new Properties();
        properties.setProperty("org.quartz.threadPool.threadNamePrefix", "my-custom-scheduler1_Worker");
        factory.setQuartzProperties(properties);
        factory.setDataSource(dataSource);
        return factory;
    }
	
	//@Bean()
	public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		return scheduler;
	}
	
}
