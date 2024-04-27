package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.bean.Constructor2Bean;
import com.example.config.AppConfig;

public class StartApplication1 {
public static void main(String[] args) throws InterruptedException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
	
	Constructor2Bean cBean = context.getBean(Constructor2Bean.class);
	System.out.println("cBean: "+ cBean);
	
	Thread.sleep(50000);
	context.close();
}
}
