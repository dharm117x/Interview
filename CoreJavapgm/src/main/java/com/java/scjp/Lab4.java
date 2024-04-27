package com.java.scjp;

public class Lab4 {
	public static void main(String[] args) {
		test("invlid");
	}

	private static void test(String s) {
		float f = 0;
		try {
			f = Float.parseFloat(s);
		} catch (NumberFormatException e) {
			f = 0;
		} finally {
			System.out.println(f);
		}

	}
}
