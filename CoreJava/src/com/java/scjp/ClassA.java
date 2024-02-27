package com.java.scjp;

public class ClassA {
	Integer i;
	int x;
	
	public ClassA(int y) {
		x=i+y;
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		new ClassA(new Integer(4));
	}
	
}
