package com.java.utility;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility2 {

	public static void main(String[] args) {
		String[] headers = { "Name", "Age", "City" };
		List<Object[]> datas = new ArrayList<>();
		datas.add(new Object[]{ "John Doe", 30, "New York" });
		datas.add(new Object[]{ "Jane Smith", 25, "London" });
		datas.add(new Object[]{ "Bob Johnson", 40, "Paris" });

		byte[] excel = genrateExcel(headers, datas, "Person");
		System.out.println(excel);

	}

	public static byte[] genrateExcel(String[] headers, List<Object[]> rows, String sheetName) {
		// Create a new workbook
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			Sheet sheet = workbook.createSheet(sheetName);

			// Create a header row
			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
			}

			int rowNum = 1;
			for (Object[] rowData : rows) {
				Row row = sheet.createRow(rowNum++);
				int colNum = 0;
				for (Object value : rowData) {
					Cell cell = row.createCell(colNum++);
					if (value instanceof String) {
						cell.setCellValue((String) value);
					} else if (value instanceof Integer) {
						cell.setCellValue((Integer) value);
					}
				}
			}
			// Auto-size columns
			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}

			workbook.write(os);
			return os.toByteArray();
		} catch (Exception e) {

		}
		return null;
	}
}