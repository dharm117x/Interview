package com.java.scjp;

public class Lab1 {
public static void main(String[] args) {
	Object o = new int[] {1,2,3};
	int[] a= (int[]) o;
	for (int i : a) {
		System.out.println(i);
	}
}
}
