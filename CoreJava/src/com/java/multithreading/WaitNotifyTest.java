package com.java.multithreading;

public class WaitNotifyTest {
public static void main(String[] args) {
	Message msg = new Message("process it");
	Waiter waiter = new Waiter(msg, "TW");
	waiter.start();
	
	Waiter waiter1 = new Waiter(msg, "TW1");
	waiter1.start();
	
	Notifier notifier = new Notifier(msg, "TN");
	notifier.start();
	
	System.out.println("All thread started.");
}
}
