package com.java.scjp;

public class Lab7 {
public static void main(String[] args) {
	try {
		test();
	} catch (RuntimeException e) {
		System.out.println("runtime");
	}
	System.out.println("end");
}

public static void test() throws RuntimeException {
	try {
		System.out.println("test");
		throw new RuntimeException();
	} catch (Exception e) {
		System.out.println("Exception");
	}
}
}
