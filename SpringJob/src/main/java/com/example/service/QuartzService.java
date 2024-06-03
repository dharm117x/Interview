package com.example.service;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class QuartzService {

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob().ofType(SampleJob.class).storeDurably().withIdentity("Qrtz_Job_Detail")
				.withDescription("Invoke Sample Job service...").build();
	}

	@Bean
	public Trigger trigger(JobDetail job) {
		return TriggerBuilder.newTrigger().forJob(job).withIdentity("Qrtz_Trigger").withDescription("Sample trigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInMinutes(1)).build();
	}

	@Bean
	public CronTrigger cronTrigger(JobDetail job) {
		return TriggerBuilder.newTrigger().forJob(job).withIdentity("cron trigger", "group1").withDescription("Cron trigger")
				.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?")).build();
	}
	
	public void jobStart() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
	}

}
