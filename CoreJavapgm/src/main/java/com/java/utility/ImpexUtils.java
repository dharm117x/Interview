package com.java.utility;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.StringCharacterIterator;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.CellType;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

public class ImpexUtils {

	static int chunk = 100;

	public static void genrateImpex(String filepath, String filename, String header, Integer[] cells) {

		try (FileInputStream fi = new FileInputStream(filepath); ReadableWorkbook book = new ReadableWorkbook(fi)) {
			Sheet sheet = book.getSheet(0).get();
			try (Stream<Row> rows = sheet.openStream();) {
				Object[] array = rows.toArray();
				int N = array.length;
				StringBuilder br = new StringBuilder(header + "\n");
				for (int i = 1; i < N; i += chunk) {
					int min = Math.min(N, i + chunk);
					for (int j = i; j < min; j++) {
						Row row = (Row) array[j];
						StringBuilder line = new StringBuilder();
						for (int k = 0; k < cells.length; k++) {
							System.out.println(row.getCell(cells[k]).getType());
							if (row.getCell(cells[k]).getType().equals(CellType.NUMBER)) {
								line.append(";" + row.getCellAsNumber(cells[k]).get());
							}else if (row.getCell(cells[k]).getType().equals(CellType.FORMULA)) {
								line.append(";" + row.getCellAsDate(cells[k]).get());
							} else {
								line.append(";" + row.getCellAsString(cells[k]).get());
							}
						}
						line.append(";\n");
						br.append(line);
					}

					String impexFile = new File(filepath).getParent() + "/" + filename + "_" + i + "_" + min + ".txt";
					//Files.writeString(Paths.get(impexFile), br, StandardCharsets.UTF_8);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
