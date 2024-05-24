package com.example.pojo;

import java.io.Serializable;

public class Employee  implements Serializable{
	private static final long serialVersionUID = 1L;

	int id;
	String empno;
	String ename;
	double salary;
	String job;

	public Employee() {
	}
	
	public Employee(String empno, String ename, double salary, String job) {
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.job = job;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", job=" + job
				+ "]";
	}
	
	
}
