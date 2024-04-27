package com.java.exception;

import java.io.File;
import java.io.FileReader;

public class TryWithResource {
	public static void main(String[] args) {
		String pathname = "test.txt";
		try (FileReader fr = new FileReader(new File(pathname))) {
			int i;
			while ((i = fr.read()) != -1)
				System.out.print((char) i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
