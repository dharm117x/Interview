package com.example.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public final class TestBean {

	public TestBean() {
		System.out.println("TestBean.TestBean()");
	}

	@PostConstruct
	public void setup() {
		System.out.println("TestBean.setup()");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("TestBean.close()");
	}
	
	
}
