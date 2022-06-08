package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupApi {
	public static void main(String[] args) {
		
		List<SaleData> datas = new ArrayList<>();
		datas.add(new SaleData("Jan", 100.0));
		datas.add(new SaleData("Jan", 100.0));
		datas.add(new SaleData("Feb", 300.0));
		datas.add(new SaleData("Mar", 400.0));
		datas.add(new SaleData("Dec", 500.0));
		datas.add(new SaleData("Dec", 500.0));
		
		List<SaleData> sorted = datas.stream().sorted(Comparator.comparing(SaleData::getAmt, Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println("Sorted by Amt-> "+sorted);
		
		Map<String, Double> collect = datas.stream()
				.collect(Collectors.groupingBy(SaleData::getMonth, Collectors.summingDouble(SaleData::getAmt)));

		List<SaleData> collect2 = collect.entrySet().stream().sorted((m1,m2)->m2.getValue().compareTo(m1.getValue()))
				.map(e -> new SaleData(e.getKey(), e.getValue())).collect(Collectors.toList());
		
		System.out.println(collect2);
	}

}
