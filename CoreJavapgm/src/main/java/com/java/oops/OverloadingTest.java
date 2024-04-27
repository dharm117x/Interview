package com.java.oops;

public class OverloadingTest {

//	public void m1() {
//		System.out.println("OverloadingTest.m1()");
//	}
//
//	public void m1(String s) {
//		System.out.println("OverloadingTest.m1(String)");
//	}
//	public void m1(Integer i) {
//		System.out.println("OverloadingTest.m1(Integer)");
//	}
//	
	public void m1(Object o) {
		System.out.println("OverloadingTest.m1(Object)");
	}

	public Long m1(Long o) {
		System.out.println("OverloadingTest.m1(Long )");
		return o;
	}

	public static void main(String[] args) {
		OverloadingTest t= new OverloadingTest();
		//t.m1(null); //The method m1(String) is ambiguous for the type OverloadingTest
//		t.m1((String)null);
		t.m1(1L);
	}
}
