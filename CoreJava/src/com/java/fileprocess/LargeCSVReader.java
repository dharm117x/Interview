package com.java.fileprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java.stream.SalesData;
import com.java.stream.StreamGroupApi;

public class LargeCSVReader {
	public static void main(String[] args) {
		List<SalesData> datas = processInputFile("salesdata2.csv");
		System.out.println(datas);
		StreamGroupApi.groupedByMonth(datas);
	}

	private static Function<String, SalesData> mapToItem = (line) -> {
		String[] p = line.split(",");// a CSV has comma separated lines
		SalesData item = new SalesData();
		item.setMonth(p[0]);
		item.setAmt(Double.parseDouble((p[1])));
		if(p.length > 2 && p[2]!= null) {
			item.setCat(p[2]);
		}
		return item;
	};

	private static List<SalesData> processInputFile(String inputFilePath) {
		List<SalesData> inputList = new ArrayList<SalesData>();
		try (InputStream inputFS = new FileInputStream(inputFilePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));) {

			// skip the header of the csv
			inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputList;

	}

}
