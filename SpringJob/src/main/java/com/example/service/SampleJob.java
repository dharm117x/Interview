package com.example.service;

import java.text.MessageFormat;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		String param = dataMap.getString("param");
		
		System.out.println(MessageFormat.format("Job:>> {0}; Param: {1}; Thread: {2}", getClass(), param, Thread.currentThread().getName()));

	}
}
