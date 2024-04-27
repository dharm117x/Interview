package com.java.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNoneRepeatChar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String data = s.nextLine();

		logic(data);

	}

	private static void logic(String data) {
		char[] array = data.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();
		int ct = 1;
		for (char c : array) {
			Character ch = new Character(c);
			if(map.containsKey(ch)) {
				int t = (int)map.get(ch);
				map.put(ch, t+1);
			}else {
				map.put(ch, ct);
			}
		}
		
		System.out.println(map);
		
		Character character = map.entrySet().stream().filter(f-> f.getValue()==1L).map(m->m.getKey()).findFirst().get();
		System.out.println(character);
		
	}
	
	
	private static void logic1(String data) {
		LinkedHashMap<Character,Long> hashMap = data.chars().mapToObj(m -> Character.toLowerCase((char) m))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
		Character charc = hashMap.entrySet().stream().filter(f-> f.getValue()==1L).map(e->e.getKey()).findFirst().get();
		System.out.println(charc);
	}
}
