package com.example;

import org.quartz.SchedulerException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.config.AppConfig;
import com.example.service.CronJobService;
import com.example.service.QuartzService;
import com.example.service.SampleJobService;

public class MainApplication {
public static void main(String[] args) throws InterruptedException, SchedulerException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);

	String[] names = context.getBeanDefinitionNames();
	for (String string : names) {
		System.out.println("Name::->" + string);
	}
	
	//CronJobService jobService = context.getBean(CronJobService.class);
	//jobService.reportCurrentTime();
	
	//SampleJobService jobService2 = context.getBean(SampleJobService.class);
	//jobService2.executeSampleJob();
	
	QuartzService quartzService = context.getBean(QuartzService.class);
	quartzService.jobStart();
	
	//Thread.sleep(2000);
	//context.close();
	
}
}
