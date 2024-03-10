package com.java.codility;

public class MinimumNumberOfGlasses {
	static int solution(int N, int K) {
		int ans = 0;
		for (int i = N; K > 0 && i > 0; i--) {
			if (i <= K) {
				ans++;
				K -= i;
			}
		}
		return K == 0 ? ans : -1;
	}
	
	public static void sol(int N, int K) {
		int ans=0;
		if(N >= K) {
			ans= 1;
		}else {
			for (int i = N; i>0; i--) {
				
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(5, 8)); // 2
		System.out.println(solution(4, 10)); // 4
		System.out.println(solution(1, 8)); // -1
		System.out.println(solution(10, 5)); // 1
		System.out.println(solution(3, 6)); // 3
		
		// N 1..1,000,000
	}

}
