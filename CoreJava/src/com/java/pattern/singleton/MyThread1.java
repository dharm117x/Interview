package com.java.pattern.singleton;

public class MyThread1 extends Thread {
	
	public MyThread1(String name) {
		super(name);
	}
	@Override
	public void run() {
		Singleton instance = Singleton.getInstance();
		System.out.println(instance);
	}
}
