package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorBean {

	private BeanA beanA;
	private BeanB beanB;
	
	public ConstructorBean(BeanA beanA) {
		System.out.println("ConstructorBean.ConstructorBean(1)");
		this.beanA = beanA;
	}

	@Autowired
	public ConstructorBean(BeanA beanA, BeanB beanB) {
		System.out.println("ConstructorBean.ConstructorBean(1, 2)");
		this.beanA = beanA;
		this.beanB = beanB;
	}

	@Override
	public String toString() {
		return "ConstructorBean [beanA=" + beanA + ", beanB=" + beanB + "]";
	}
	
}
