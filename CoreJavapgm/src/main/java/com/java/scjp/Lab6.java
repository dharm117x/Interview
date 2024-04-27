package com.java.scjp;

import java.io.File;
import java.io.IOException;

public class Lab6 {
public static void main(String[] args) {
	try {
		File d = new File("d:");
		File f = new File(d, "f ");
		
		if(!f.exists()) {
			f.createNewFile();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
