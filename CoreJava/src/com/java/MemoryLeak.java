package com.java;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
	
	static List<Double> datas = new ArrayList<>();
	
	private void addDataToList() throws InterruptedException {
		for (int i = 0; i < 1000000; i++) {
			datas.add(Math.random());
		}
		System.out.println("Step 0");
		
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step 1");
		new MemoryLeak().addDataToList();
		System.out.println("Step 2");
		
	}
	
	@Override
	protected void finalize() throws Throwable {
	System.out.println("MemoryLeak.finalize()");
	}
}
