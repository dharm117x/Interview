package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupApi {
	public static void main(String[] args) {
		SaleData data1 = new SaleData("Jan", 122.0);
		SaleData data2 = new SaleData("Jan", 102.0);
		SaleData data4 = new SaleData("Dec", 522.99);
		SaleData data5 = new SaleData("Feb", 422.99);
		SaleData data3 = new SaleData("Mar", 422.99);
		
		
		List<SaleData> datas = new ArrayList<>();
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);
		datas.add(data4);
		datas.add(data5);
		
		System.out.println("Deafult:: "+datas);
		List<SaleData> sorted = datas.stream().sorted(Comparator.comparing(SaleData::getAmt, Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println("Sorted by Amt-> "+sorted);
		
		Map<String, Double> collect = datas.stream()
				.collect(Collectors.groupingBy(SaleData::getMonth, Collectors.summingDouble(SaleData::getAmt)));

		System.out.println(collect);

		List<SaleData> collect2 = collect.entrySet().stream().sorted((m1,m2)->m2.getKey().compareTo(m1.getKey()))
				.map(e -> new SaleData(e.getKey(), e.getValue())).collect(Collectors.toList());
		
		System.out.println(collect2);
	}

}
