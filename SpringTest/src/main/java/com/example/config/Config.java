package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.example.bean.TestBean;

@PropertySource("classpath:application.properties")
@ImportResource(locations = "classpath:spring.xml")
@Configuration
public class Config {
	
	@Value("${data}")
	String data;
	
	@Bean
	public TestBean testBean1() {
		System.out.println("Config.testBean1() Data::  "+data);
		return new TestBean();
	}
}
