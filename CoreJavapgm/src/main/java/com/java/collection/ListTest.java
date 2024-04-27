package com.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListTest {
	// Main driver method
    public static void main(String[] args)
    {
 
        // Creating arrayList list dynamically
        List<String> list = new ArrayList<String>(100);
        // List is created
        // Adding elements to the list
        list.add("One");
        list.add("Two");
        list.add("One");
        list.add(1, "Three");
        list.add("One");
        list.add("One");
        
        list.remove("One");

        System.out.println(list);
        
        List<String> list1 = new LinkedList<String>();
        // List is created
        // Adding elements to the list
        list1.add("One");
        list1.add("Two");
       // list1.add(11, "three ");// java.lang.IndexOutOfBoundsException: Index: 11, Size: 2
        list1.add("One");
        list1.add("One");
        
        list1.remove("One");
        System.out.println(list1);
   
        
       
    }
}
