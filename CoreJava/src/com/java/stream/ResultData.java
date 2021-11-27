package com.java.stream;

public class ResultData {
	int rollno;
	String name;
	int marks;

	public ResultData() {
	}

	public ResultData(int rollno, String name, int marks) {
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "ResultData [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
