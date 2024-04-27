package com.java.multithreading;

public class Notifier extends Thread {

	Message msg;

	public Notifier(Message msg, String name) {
		super(name);
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " Started");
		try {
			synchronized (msg) {
				Thread.sleep(1000);
				msg.setMsg(name +" Notifier Work done.");
				msg.notify();
				//msg.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
