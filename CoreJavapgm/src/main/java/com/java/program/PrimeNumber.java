package com.java.program;

public class PrimeNumber {
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			if (isPrime(i)) {
				System.out.print(i+" ");
			}
		}

	}

	private static boolean isPrime(int test) {
		if (test == 0 || test == 1) {
			return false;
		}
		for (int i = 2; i < test / 2 + 1; i++) {
			if (test % i == 0) {
				return false;
			}
		}
		return true;
	}
}
