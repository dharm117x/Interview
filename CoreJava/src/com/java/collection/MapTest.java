package com.java.collection;

import java.util.HashMap;

public class MapTest {

	static HashMap<User, Object> map = new HashMap<>();
	
	public static void main(String[] args) {
		map.put(null, "A");
		
		map.put(new User(1, "A"), "B");
		map.put(new User(1, "A"), "C");
		map.put(new User(2, "A"), "D");
		
		
		System.out.println(map);
	}
}
