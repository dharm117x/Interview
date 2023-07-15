package com.example.utils;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.example.bean.Employee;

public class Reader implements ItemReader<Employee> {

	public Employee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		return new Employee();
	}

}
