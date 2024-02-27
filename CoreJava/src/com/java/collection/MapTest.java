package com.java.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest {

	
	public static void main(String[] args) {
		hashmapTest();
		linkedhashmapTest();
	}

	private static void hashmapTest() {
		HashMap<User, Object> map = new HashMap<>();
		map.put(null, "A");
		map.put(new User(1, "A"), "B");
		map.put(new User(1, "A"), "C");
		map.put(new User(2, "A"), "D");
		
		System.out.println(map);
	}
	
	private static void linkedhashmapTest() {
		HashMap<User, Object> map = new LinkedHashMap<>();
		map.put(null, "A");
		map.put(new User(1, "A"), "B");
		map.put(new User(1, "A"), "C");
		map.put(new User(2, "A"), "D");
		
		System.out.println(map);
	}
	
}
