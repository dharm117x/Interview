package com.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiTest3 {
	public static void main(String[] args) {
		List<ResultData> datas = new ArrayList<>();
		ResultData data = new ResultData(2, "Dharma", 100);
		ResultData data1 = new ResultData(1, "Shalini", 90);
		ResultData data2 = new ResultData(5, "Ayansh", 190);

		datas.add(data);
		datas.add(data1);
		datas.add(data2);

		
		List<ResultData> list = datas.stream()
				.sorted((d1, d2) -> (d1.rollno - d2.rollno))
				.collect(Collectors.toList());
		
		boolean anyMatch = list.stream().limit(2).anyMatch(d-> d.rollno==5);
		System.out.println(anyMatch);
		
		list.forEach(System.out::print);
		
		System.out.println("\n-----------");
		datas.stream().sorted((d1, d2)-> d1.name.compareTo(d2.name)).forEach(System.out::print);

	}
}
