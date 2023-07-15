package com.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.AopConfig;
import com.example.EmployeeManager;

public class TestAOP
{
    @SuppressWarnings("resource")
    public static void main(String[] args) {
  
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
 
        EmployeeManager manager = context.getBean(EmployeeManager.class);
  
        manager.getEmployeeById(1);
    }
}