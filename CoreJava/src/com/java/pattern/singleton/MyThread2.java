package com.java.pattern.singleton;

public class MyThread2 extends Thread {
	
	public MyThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		Singleton instance = Singleton.getInstance();
		System.out.println(instance);
	}
}
