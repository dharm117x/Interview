package com.java.pattern.factory;

public class DrinkFactory {
	public Drink getDrink(String drinkType) {

		if (drinkType == null) {
			return null;
		}
		if (drinkType.equalsIgnoreCase("COFFEE")) {
			return new Coffee();
		} else if (drinkType.equalsIgnoreCase("TEA")) {
			return new Tea();
		}
		return null;
	}
}
