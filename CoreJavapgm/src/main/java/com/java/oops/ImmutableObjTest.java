package com.java.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ImmutableObjTest {
public static void main(String[] args) {
	List<String> data = Arrays.asList("1","2");// its fixed size can't change -UnsupportedOperationException
	
	List<String> data1 = new ArrayList<>();
	data1.add("1");
	data1.add("2");
	
	ImmutableObj obj = new ImmutableObj("DK", new Date(), data1);
	System.out.println(obj);
	
	//obj.getData().add("3");
	obj.getName().concat("Sharma");
	obj.getDob().setYear(2005);
	System.out.println(obj);
}
}
