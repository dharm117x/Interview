package com.example.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class SampleJobService {

	
	public Scheduler scheduler;

	public void executeSampleJob() throws SchedulerException {

		JobDetail job = JobBuilder.newJob(SampleJob.class).usingJobData("param", "value") // add a parameter
				.build();

		Date afterFiveSeconds = Date
				.from(LocalDateTime.now().plusSeconds(5).atZone(ZoneId.systemDefault()).toInstant());
		
		Trigger trigger = TriggerBuilder.newTrigger().startAt(afterFiveSeconds).build();

		scheduler.scheduleJob(job, trigger);
	}

}
