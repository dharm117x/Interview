package com.java.scjp;

public class Lab5 {
	
	public static void name(long n) {
		System.out.println("long");
	}

	public static void name(Long n) {
		System.out.println("Long");
	}

	public static void name(short n) {
		System.out.println("short");
	}

	public static void name(Short n) {
		System.out.println("Short");
	}

	public static void name(int n) {
		System.out.println("int");
	}

	public static void name(Integer n) {
		System.out.println("Integer");
	}
	
	public static void test(String s) {
		System.out.println("String");
	}
	
	public static void test(Object s) {
		System.out.println("Object");
	}
	
	public static void main(String[] args) {
        Short x=6;
		name(x);
		
		int y=6;
		name(y);
		
		long z=7;
	//	name((Long)null);
		
//		test("a");
	}
}
