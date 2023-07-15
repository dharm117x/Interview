package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.config.AppConfig;

public class StartApplication {
public static void main(String[] args) throws InterruptedException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);

	String[] names = context.getBeanDefinitionNames();
	for (String string : names) {
		System.out.println("Name::->" + string);
	}
	
	Thread.sleep(60000);
	context.close();
}
}
