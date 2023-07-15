package com.example.utils;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.example.bean.Employee;

public class Writer implements ItemWriter<Employee> {

	public void write(List<? extends Employee> items) throws Exception {
		
	}

}
