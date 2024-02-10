package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.bean.BeanA;
import com.example.bean.ConstructorBean;
import com.example.bean.PrototypeBean;
import com.example.bean.SingltonBean;
import com.example.bean.TestBean;
import com.example.config.AppConfig;

public class StartApplication {
public static void main(String[] args) throws InterruptedException {
	AbstractApplicationContext context = new  AnnotationConfigApplicationContext(AppConfig.class);

	String[] names = context.getBeanDefinitionNames();
	for (String string : names) {
		//System.out.println("Name::->" + string);
	}
	TestBean bean1 = context.getBean("testBean1",TestBean.class);
	System.out.println("OP1 : "+bean1);
	TestBean bean2 = context.getBean("testBean2",TestBean.class);
	System.out.println("OP2 : "+bean2);
	
	SingltonBean singltonBean = context.getBean(SingltonBean.class);
	System.out.println("SOP1 : "+singltonBean);
	System.out.println("SPBean1 : " + singltonBean.getPrototypeBean());
	
	SingltonBean singltonBean1 = context.getBean(SingltonBean.class);
	System.out.println("SOP2 : "+singltonBean1);
	System.out.println("SPBean2 : " + singltonBean1.getPrototypeBean());
	
	PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
	System.out.println("POP1 : "+prototypeBean);
	PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
	System.out.println("POP2 : "+prototypeBean1);

	BeanA bean = context.getBean(BeanA.class);
	System.out.println("bean: "+ bean.getBeanB());
	
	ConstructorBean cBean = context.getBean(ConstructorBean.class);
	System.out.println("cBean: "+ cBean);
	
	String bean3 = context.getBean("string#two", String.class);
	System.out.println(bean3);
	
	Thread.sleep(50000);
	context.close();
}
}
