package com.java.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 2 };
		print(arr);
		System.out.println("");
		sort(arr);
		print(arr);
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		boolean swap = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
			}
			if (swap == false)
                break;
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
}
