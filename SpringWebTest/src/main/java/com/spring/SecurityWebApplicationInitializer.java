package com.spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

import jakarta.servlet.ServletContext;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	

	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		System.out.println("SecurityWebApplicationInitializer.afterSpringSecurityFilterChain()");
		insertFilters(servletContext, new MultipartFilter());
	}
	
	
}
