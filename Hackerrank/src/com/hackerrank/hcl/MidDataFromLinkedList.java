package com.hackerrank.hcl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MidDataFromLinkedList {
public static void main(String[] args) {
	List<Integer> data = new LinkedList<Integer>();
	data.add(1);
	data.add(3);
	data.add(4);

	data.add(5);
	
	data.add(6);
	data.add(8);
	data.add(9);
	
	ListIterator<Integer> it = data.listIterator();
	
	while (it.hasNext()) {
		Integer n1  = it.next();
		System.out.println("n1---"+n1);
		if(it.hasNext()) {
			Integer n2 = it.next();
			System.out.println("n2--"+n2);
		}
		
	}
													
	
	
}
}
