package com.java.program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CharCount {
	public static void main(String[] args) {
		solution("aaabb99");
		removeDuplicate("aaabb99");
	}

	public static void solution(String str) {
		char[] array = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}

			map.putIfAbsent(array[i], count);
		}
		System.out.println(map);
	}

	public static void removeDuplicate(String str) {
		char[] array = str.toCharArray();
		int index=0;
		
		for (int i = 0; i < array.length; i++) {
			int j;
			for (j = 0; j < i; j++) {
				if(array[i]==array[j]) {
					break;
				}
			}
			if(j==i) {
				array[index++]=array[i];
			}
		}

		System.out.println(Arrays.copyOf(array, index));
	}
}
