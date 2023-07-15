package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.example.bean.TestBean;

@Configuration
@Import(Config.class)
@ComponentScan(basePackages = "com.example")
public class AppConfig {

	@Bean
	public TestBean testBean2() {
		
		return new TestBean();
	}
	
	
}
