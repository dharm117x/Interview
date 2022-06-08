package com.java.fileprocess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileProcess {
public static void main(String[] args) throws IOException {
	FileInputStream inputStream = null;
	Scanner sc = null;
	try {
	    String path = "test.txt";
		inputStream = new FileInputStream(path );
	    sc = new Scanner(inputStream, "UTF-8");
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	         System.out.println(line);
	    }
	    // note that Scanner suppresses exceptions
	    if (sc.ioException() != null) {
	        throw sc.ioException();
	    }
	} finally {
	    if (inputStream != null) {
	        inputStream.close();
	    }
	    if (sc != null) {
	        sc.close();
	    }
	}
}
}
