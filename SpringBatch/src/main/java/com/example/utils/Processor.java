package com.example.utils;

import org.springframework.batch.item.ItemProcessor;

import com.example.bean.Employee;

public class Processor implements ItemProcessor<Employee, Employee>{

	public Employee process(Employee item) throws Exception {

		return item;
	}

}
