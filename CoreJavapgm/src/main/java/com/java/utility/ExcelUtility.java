package com.java.utility;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static void main(String[] args) {
		String[] headers = { "Name", "Age", "City" };
		// Add data rows
		Object[][] data = {{ "John Doe", 30, "New York" }, { "Jane Smith", 25, "London" },
				{ "Bob Johnson", 40, "Paris" }};
		
		genrateExcel(headers, data, "Person");

	}

	public static void genrateExcel(String[] headers, Object[][] rows, String fileName) {
		// Create a new workbook
		Workbook workbook = new XSSFWorkbook();

		// Create a new sheet
		Sheet sheet = workbook.createSheet("Sheet1");

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

		// Save the workbook to a file
		try (FileOutputStream fos = new FileOutputStream(fileName+".xlsx")) {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Excel file created successfully.");
	}
}