package com.hackerrank.hcl;

public class ArraySumTest {
public static void main(String[] args) {
	int arr[] = {2,4,5,6,7,9};
	for (int i = 0; i < arr.length; i++) {
		for (int j = 1; j < arr.length-1; j++) {
			if(arr[i]+arr[j]==10) {
				System.out.println(i+"-"+j+"--"+arr[i]+"-"+arr[j]);
				
			}
		}
	}
	
	
}
}
