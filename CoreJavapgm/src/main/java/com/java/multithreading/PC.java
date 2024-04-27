package com.java.multithreading;

import java.util.LinkedList;
import java.util.List;

public class PC {
	LinkedList<Integer> list = new LinkedList<Integer>();
	int capacity = 2;

	public void produce() throws InterruptedException {

		int value=0;
		while (true) {
			synchronized (this) {
				while(list.size()==capacity) {
					wait();
				}
				
				System.out.println("Producer produce value::"+value);
				list.add(value++);
				notify();
				Thread.sleep(1000);
			}
		}
	}


	public void consume() throws InterruptedException {

		while (true) {
			synchronized (this) {
				while (list.size()==0) {
					wait();
				}
				Integer first = list.removeFirst();
				System.out.println("Consumer consumeed::"+first);
				notify();
				Thread.sleep(1000);
			}
		}
	}

	
}
