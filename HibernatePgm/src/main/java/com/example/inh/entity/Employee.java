package com.example.inh.entity;

import javax.persistence.Entity;

@Entity
public class Employee extends Person{

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
