    package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.config.AppConfig;
import com.example.service.SpringJdbService;

public class StartApplication {
public static void main(String[] args) throws InterruptedException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);

	String[] names = context.getBeanDefinitionNames();
	for (String string : names) {
		System.out.println("Name::->" + string);
	}
	SpringJdbService service = context.getBean(SpringJdbService.class);
	System.out.println("EMP:: "+service.getData());
	
	Thread.sleep(2000);
	context.close();
}
}
