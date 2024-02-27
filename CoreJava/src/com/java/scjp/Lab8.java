package com.java.scjp;

public class Lab8 {
public static void main(String[] args) {
	try {
		args=null;
		args[0]="test";
	} catch (RuntimeException e) {
		System.out.println("RuntimeException");
	} catch (Exception e) {
		System.out.println("Exception");
	}
}
}
