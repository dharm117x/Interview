package com.java8.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	static List<Integer> data = new ArrayList<>();
	static {
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
	}

	public static void main(String[] args) {
		//filterTest(3);
	}

	public static void filterTest(Integer d) {
		List<Integer> list = data.stream().filter(f -> f.equals(d)).collect(Collectors.toList());
		list.forEach(p -> System.out.println(p));
	}

	public static void matchTest(Integer d) {
		if (data.stream().anyMatch(p -> p == d)) {
			System.out.println("OK");
		}
		System.out.println("NOK");
	}

}
