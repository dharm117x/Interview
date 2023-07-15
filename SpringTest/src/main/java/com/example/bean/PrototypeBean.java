package com.example.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public final class PrototypeBean {

	public PrototypeBean() {
		System.out.println("PrototypeBean.TestBean()");
	}

	@PostConstruct
	public void setup() {
		System.out.println("PrototypeBean.setup()");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("PrototypeBean.close()");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("PrototypeBean.finalize()");
	}
	
}
