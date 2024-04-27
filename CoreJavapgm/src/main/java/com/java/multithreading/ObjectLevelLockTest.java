package com.java.multithreading;

public class ObjectLevelLockTest implements Runnable {
	
	@Override
	public void run() {
		objectLock();
	}

	public void objectLock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("Synchronized block " + Thread.currentThread().getName());
			System.out.println("Synchronized block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		ObjectLevelLockTest test1 = new ObjectLevelLockTest();
		Thread t1 = new Thread(test1);
		Thread t2 = new Thread(test1);
		ObjectLevelLockTest test2 = new ObjectLevelLockTest();
		Thread t3 = new Thread(test2);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}