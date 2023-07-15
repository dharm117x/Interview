package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.SpringJdbcDao;
import com.example.pojo.Employee;

@Component
public class SpringJdbService {

	@Autowired
	SpringJdbcDao springJdbcDao;
	
	@Transactional
	public Employee getData() {
		List<Employee> test = springJdbcDao.empSearch();
		return test.get(0);
	}
}
