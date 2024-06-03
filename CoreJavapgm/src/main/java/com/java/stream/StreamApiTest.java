package com.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTest {
	public static void main(String[] args) {
		List<String> datas = new ArrayList<>();
		datas.add("1");
		datas.add("2");
		datas.add("4");
		datas.add("3");

		findByName(datas, "1");
		sortByName(datas);
	}

	static void findByName(List<String> names, String search) {
		boolean match = names.stream().anyMatch(p -> p.equalsIgnoreCase(search));
		if (match) {
			System.out.println("Find");
		} else {
			System.out.println("Not found");
		}
	}

	static void sortByName(List<String> names) {
		List<String> datas = names.stream().collect(Collectors.toList());
		System.out.println(datas);

		names.stream().sorted((o1, o2) -> {
			return o1.compareTo(o2);
		}).forEach(System.out::print);
	}

}
