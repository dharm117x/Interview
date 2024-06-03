package com.spring.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@ComponentScan({"com.spring"})
public class SpringWebConfig implements WebMvcConfigurer {

	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new JsonbHttpMessageConverter());
	}
}

