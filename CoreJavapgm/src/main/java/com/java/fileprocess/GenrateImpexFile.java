package com.java.fileprocess;

import com.java.utility.ImpexUtils;

public class GenrateImpexFile {
public static void main(String[] args) {
	String filepath = "D:\\Interview\\Hybris\\data\\Students.xlsx";
	String header = "INSERT_UPDATE Student;sid[unique=true];name;phone;email;DOB";
	
	Integer[] cells= {0,1,3,4,5};
	ImpexUtils.genrateImpex(filepath, "Student", header, cells);
}
}
