package com.java.interview;

public class Swap {
// java always pass by value	
static void swap(int a, int b) {
	int tmp;
	tmp = a;
	a= b;
	b=tmp;
	
	System.out.println(a);
	System.out.println(b);
}

public static void main(String[] args) {
	int a=4, b=5;
	swap(a, b);
	System.out.println("a:"+a);
	System.out.println("b:"+b);
}
}
