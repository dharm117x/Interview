package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiMapTest {
	public static void main(String[] args) {

		List<List<String>> data= new ArrayList<>();
		data.add(Arrays.asList("One","Two"));
		data.add(Arrays.asList("Two-1","Three"));
	
		List list = data.stream().map(m->m).collect(Collectors.toList());
		System.out.println(list);
	
		List<String> collect = data.stream().flatMap(m->m.stream()).collect(Collectors.toList());
		System.out.println(collect);
		
		
	}
}	
