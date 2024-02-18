package com.java.program;

public class FindLargeNumber {
	public static void main(String[] args) {
		int[] data = { 11, 33, 55, 99, 90, 24, 19 };
		int max = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		System.out.println("max no::" + max);
	}
}
