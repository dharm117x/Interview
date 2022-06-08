package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupApi {
	public static void main(String[] args) {
		
		List<SalesData> datas = new ArrayList<>();
		datas.add(new SalesData("Jan", 100.0));
		datas.add(new SalesData("Jan", 100.0));
		datas.add(new SalesData("Feb", 300.0));
		datas.add(new SalesData("Mar", 400.0));
		datas.add(new SalesData("Dec", 500.0));
		datas.add(new SalesData("Dec", 500.0));
		
		groupedByMonth(datas);
		
	}

	public static void groupedByMonth(List<SalesData> datas) {
		List<SalesData> sorted = datas.stream().sorted(Comparator.comparing(SalesData::getAmt, Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println("Sorted by Amt-> "+sorted);
		
		Map<String, Double> collect = datas.stream()
				.collect(Collectors.groupingBy(SalesData::getMonth, Collectors.summingDouble(SalesData::getAmt)));

		List<SalesData> collect2 = collect.entrySet().stream().sorted((m1,m2)->m2.getValue().compareTo(m1.getValue()))
				.map(e -> new SalesData(e.getKey(), e.getValue())).collect(Collectors.toList());
		
		System.out.println(collect2);
	}

}
