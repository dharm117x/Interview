package com.java.program;

import java.util.Scanner;

public class DigitCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your number:");
		long number = scanner.nextLong();

		int digitCount = countDigits(number);

		System.out.println("The number has " + digitCount + " digits.");
		scanner.close();
	}

	public static int countDigits(long number) {
		int count = 0;
		while (number != 0) {
			number /= 10;
			count++;
		}
		return count;
	}
}
