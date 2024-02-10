package com.java.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EqHasCodeTest {
// if objects are equals then hashcode must be same but not true for vice versa.	
	public static void main(String[] args) {
		Student s1 = new Student(1, "A");

		Student s2 = new Student(1, "A");

		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);

		System.out.println("s1.hashCode():  " + s1.hashCode() + "  s2.hashCode():" + s2.hashCode());
		
		HashSet<Student> stuSets = new HashSet<Student>();
		stuSets.add(s1);
		System.out.println(stuSets.contains(s2));
	
		List<Student> stuList = new ArrayList<>();
		stuList.add(s1);
		System.out.println(stuList.contains(s2));
		
	
	}
}
