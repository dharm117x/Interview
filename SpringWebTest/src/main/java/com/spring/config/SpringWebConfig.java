package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.spring.intercepter.LogIntercepter;

@EnableWebMvc
@Configuration
@ComponentScan({"com.spring"})
@Import({SpringSecurityConfig.class})
public class SpringWebConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewresolver() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/pages/");
		ivr.setSuffix(".jsp");
		ivr.setViewClass(JstlView.class);
		return ivr;
	}
	
	@Bean(name = "filterMultipartResolver")
	 public CommonsMultipartResolver getMultipartResolver() {
	      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	      return multipartResolver;
	 }
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogIntercepter());
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/uploadFileView.html").setViewName("fileuploadPage");
		registry.addViewController("/singlieUploadFileView.html").setViewName("singleFileuploadPage");
		registry.addViewController("/sessionExpiredPage.html").setViewName("sessionExpiredPage");
		
	}
	
}

