package com.java.oops;

import java.io.IOException;

public class Child extends Parent {

	// Exception should be same or child class
	@Override
	public void m1() throws IOException{ 
		System.out.println("Child.m1()");
	}
	
	public static void m2() {
		System.out.println("Child.m2()");
	}
	
	// signature should matched
	// use same or higher visibility of the inherited method from Parent
	@Override
	public void m3(Object s) {
		System.out.println("Child.m3()");
	}
	
	@Override
	public void m4(int n, long ln) {
		System.out.println("Child.m4()");
	}
	
}
