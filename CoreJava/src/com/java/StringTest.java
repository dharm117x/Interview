package com.java;

public class StringTest {
	public static void main(String[] args) {
		String data = "select * from table as %s";
		String s = data.format(data, "");
		System.out.println(s);
	}
}
