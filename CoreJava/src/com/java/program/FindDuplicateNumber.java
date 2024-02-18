package com.java.program;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
	public static void main(String[] args) {
		int[] data = { 11, 11, 33, 55, 99, 99, 90, 24, 19 };
		findDuplicate(data);
		System.out.println("------------------------");
		findDuplicateBySet(data);
	}

	private static void findDuplicate(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] == data[j]) {
					System.out.println(data[i]);
				}
			}
		}
	}

	private static void findDuplicateBySet(int[] data) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < data.length; i++) {
			if(!set.add(data[i])) {
				System.out.println(data[i]);
			}
		}
		
	}
}
