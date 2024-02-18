package com.hackerrank.sort;

import java.util.Arrays;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		Integer[] spam = new Integer[] { 4, 1, 2, 3 ,8 ,5, 6};
		List<Integer> list = Arrays.asList(spam);
		countSwaps(list);
	}

	public static void countSwaps(List<Integer> datas) {
		int[] arr = datas.stream().mapToInt(i->i).toArray();
		int temp = 0;
		int n = arr.length;
		int count=0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					
					count++;
				}

			}
		}

		
		System.out.println("Array is sorted in "+count+" swaps.");
		System.out.println("First Element: "+arr[0]);
		System.out.println("Last Element: "+arr[arr.length-1]);
		
		for (int i : arr) {
			System.out.print(" " + i);
		}
		
	}

}
