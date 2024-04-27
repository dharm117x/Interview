package com.java.pattern.factory;

public class FactoryPatternTest {
	public static void main(String[] args) {
		DrinkFactory fact = new DrinkFactory();
		fact.getDrink("TEA").prepare();
	}
}
