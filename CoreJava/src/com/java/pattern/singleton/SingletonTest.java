package com.java.pattern.singleton;

public class SingletonTest {
public static void main(String[] args) {
	MyThread1 t1= new MyThread1("One");
	t1.start();
	
	MyThread2 t2= new MyThread2("Two");
	t2.start();
	
}
}
