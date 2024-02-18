package com.java.pattern.factory;

public class Coffee implements Drink{

	@Override
	public void prepare() {
		System.out.println("Coffee");
	}

}