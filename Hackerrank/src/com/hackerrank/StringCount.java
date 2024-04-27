package com.hackerrank;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCount {
public static void main(String[] args) {
	String[] data = {"WP","IN","IN","US","US"};
	
	Map<String, Long> map = Stream.of(data).collect(Collectors.groupingBy(s->s, Collectors.counting()));
	System.out.println(map);
	
}
}
