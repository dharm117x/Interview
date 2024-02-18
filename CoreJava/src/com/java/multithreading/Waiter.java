package com.java.multithreading;

public class Waiter extends Thread{

	Message msg;
	
	public Waiter(Message msg, String name) {
		super(name);
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			System.out.println(name+" Waiting to get notified--"+System.currentTimeMillis());
			try {
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+" Waiter got notified--"+System.currentTimeMillis());
			System.out.println(name+" Processed--"+msg.getMsg());
		}
	}

}
