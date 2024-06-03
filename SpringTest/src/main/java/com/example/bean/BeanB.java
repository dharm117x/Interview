package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

//	@Autowired
	BeanA beanA;

	public BeanB() {
	}
	
	@Autowired
	public BeanB(BeanA beanA) {
		this.beanA = beanA;
	}

	public BeanA getBeanA() {
		return beanA;
	}

	public void setBeanA(BeanA beanA) {
		this.beanA = beanA;
	}
	
	
}
