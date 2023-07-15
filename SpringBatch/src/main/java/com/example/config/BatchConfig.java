package com.example.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.bean.Employee;
import com.example.listener.BatchJobListener;
import com.example.utils.Processor;
import com.example.utils.Reader;
import com.example.utils.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {
	

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	@Autowired
	BatchJobListener listener;
	
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	DataSource dataSource;

	@Scheduled(cron = "0/5 * * * * ?")
	public void schdeuleBatch() {
		System.out.println("Job Start..............");
		JobParameters jobParameters = new JobParametersBuilder()
										  .addLong("time", System.currentTimeMillis())
										  .toJobParameters();
		try {
			jobLauncher.run(processJob(), jobParameters);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 
	@Bean
	public Job processJob() {
		System.out.println("BatchConfig.processJob()");
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1()).end()
				.build();
	}

	@Bean
	public Step step1() {
		System.out.println("BatchConfig.orderStep1()");
		return stepBuilderFactory.get("orderStep1").<Employee, Employee>chunk(2)
				.reader(new Reader())
				.processor(new Processor())
				.writer(new Writer())
				.build();
	}
	

 }
 
