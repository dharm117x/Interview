package com.java.pattern.factory;

public class Tea implements Drink{

	@Override
	public void prepare() {
		System.out.println("Tea");
	}

}
