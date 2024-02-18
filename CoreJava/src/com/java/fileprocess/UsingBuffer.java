package com.java.fileprocess;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UsingBuffer {
public static void main(String[] args) {
	String pathname = "test.txt";
	try(BufferedReader in = new BufferedReader(new FileReader(pathname ))) {
	    String line;
	    while ((line = in.readLine()) != null) {
	    	System.out.println(line);
	    }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	try(BufferedInputStream bi = new BufferedInputStream(new FileInputStream(pathname))) {
	    byte[] bbuf = new byte[5];
	    int len;
	    int data = bi.read();
	    while(data != -1) {
	      data = bi.read();
	      System.out.print((char)data);
	    }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
