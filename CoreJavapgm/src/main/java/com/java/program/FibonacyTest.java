package com.java.program;

public class FibonacyTest {
	// 0 1 1 2 3 5 8 13
	public static void main(String[] args) {

		int i1 = 0;
		int i2 = 1;
		for (int i = 0; i < 10; i++) {
			System.out.println(i1);
			
			int i3 = i1 + i2;
			i1 = i2;
			i2 = i3;
			
		}

	}
}
