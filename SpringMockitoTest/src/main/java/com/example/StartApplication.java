package com.example;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.config.AppConfig;
import com.example.data.User;
import com.example.service.UserService;

public class StartApplication {
public static void main(String[] args) throws InterruptedException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);
	UserService userService = context.getBean(UserService.class);

	User user1 = new User("DK","DK@g.com","12345");
	User user2 = new User("DK1","DK1@g.com","222222");
	
	userService.create(user1);
	userService.create(user2);
	
	
	userService.findAllUsers().forEach(c-> System.out.println(c.getEmail()));
	List<User> list = userService.findByName("DK");
	
	list.forEach(c->System.out.println(c.getName()));
	
	Thread.sleep(50000);
	context.close();
}
}
