package com.example.service;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronJobService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	//@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("The time is now {} "+ dateFormat.format(new Date()));
	}
	
	//@Scheduled(cron = "${cron-string}")
    public void everyFiveSeconds() {
        System.out.println(MessageFormat.format("Periodic task: {0}; Thread: {1}",
                new Date().toString(), Thread.currentThread().getName()));
    }
}
