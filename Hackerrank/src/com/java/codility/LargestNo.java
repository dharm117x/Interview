package com.java.codility;

import java.util.Arrays;

public class LargestNo {
	// return largest integer k>0 such that both value -k and K present
	// A=[3,2,-2,-3,5] ans 3 (both large exist 3, -3)
	// A= [1,1,2,-1,2, 1] ans 1(both large 1, -1)
	// A= [1, 2,3 -4] ans 0 not present both

	public static void main(String[] args) {
		int[] A = { 3, 2, 1,-4,-2 };
		solution(A);
	}

	public static void solution(int[] A) {
		int[] B= new int[A.length];
		int j=0;
		for (int i : A) {
			if(isExist(A, i)) {
				System.out.println(i);
				B[j++]=i;
			}
		}
		
		Arrays.sort(B);
		
		System.out.println("Ans "+B[B.length-1]);
	}

	private static boolean isExist(int[] A, int n) {
		return Arrays.stream(A).anyMatch(p -> (p == n)) && Arrays.stream(A).anyMatch(p -> (p == -n));
	}
}
