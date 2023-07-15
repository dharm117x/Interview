package com.spring;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		System.out.println("SecurityWebApplicationInitializer.beforeSpringSecurityFilterChain()");
 		insertFilters(servletContext, new MultipartFilter());
	}
	
	
}
