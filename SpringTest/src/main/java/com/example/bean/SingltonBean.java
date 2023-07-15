package com.example.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingltonBean {

	@Autowired
	private PrototypeBean prototypeBean;
	
	public SingltonBean() {
		System.out.println("SingltonBean.TestBean()");
	}

	//@Lookup
	public PrototypeBean getPrototypeBean() {
		return prototypeBean;
	}


	public void setPrototypeBean(PrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
	}


	@PostConstruct
	public void setup() {
		System.out.println("SingltonBean.setup()");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("SingltonBean.close()");
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("SingltonBean.finalize()");
	}
}
