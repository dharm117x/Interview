package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class Constructor2Bean {

	private BeanA beanA;
	private BeanB beanB;
	

	//@Autowired
	public Constructor2Bean(BeanA beanA, BeanB beanB) {
		System.out.println("ConstructorBean.ConstructorBean(1, 2)");
		this.beanA = beanA;
		this.beanB = beanB;
	}

	@Override
	public String toString() {
		return "ConstructorBean [beanA=" + beanA + ", beanB=" + beanB + "]";
	}
	
}
