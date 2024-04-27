package com.hackerrank;

public class FirstNoneRepeatChar {
	public static void main(String[] args) {
		String data = "abcabc".toLowerCase();
		char[] ca = data.toCharArray();

		System.out.println(getChar(ca));

	}

	private static char getChar(char[] ca) {
		boolean f = true;
		for (int i = 0; i < ca.length; i++) {
			f = true;
			for (int j = i + 1; j < ca.length; j++) {
				if (ca[i] == ca[j]) {
					f = false;
				}
			}
			if (f) {
				return ca[i];
			}
		}
		return 0;
	}
}
