package com.java.oops;

import java.io.IOException;

public class Parent{

	public void m1() throws Exception {
		System.out.println("Parent.m1()");
	}
	
	public static void m2() {
		System.out.println("Parent.m2()");
	}
	
	protected void m3(Object s) {
		System.out.println("Parent.m3()");
	}
	
	public void m4(int n, long ln) {
		System.out.println("Parent.m4()");
	}
}
