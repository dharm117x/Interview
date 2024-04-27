package com.hackerrank.hcl;

public class LCM {
	public static void main(String[] args) {
		int n1 = 2, n2 = 3, lcm;
		lcm = 1;
		while (true) {
			if (lcm % n1 == 0 && lcm % n2 == 0) {
				System.out.println(lcm);
				break;
			}
			++lcm;
		}
	}
}
