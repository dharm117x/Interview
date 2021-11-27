package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest2 {
public static void main(String[] args) {
	
	List<Integer> number = Arrays.asList(2,3,4,5);
	List<Integer> square = number.stream().map(x->x*x).collect(Collectors.toList());	
	System.out.println("Squre-->"+square);
	
	List<String> names = Arrays.asList("Reflection","Collection","Stream","Sharma");
	List<String> result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
	System.out.println("Filter-->"+result);
	List<String> sortResult = names.stream().sorted().collect(Collectors.toList());
	System.out.println("Sorting--> "+sortResult);
	
	Stream s = Stream.of(10,1,2,12,34);
	s.forEach(a-> System.out.print(" "+a));
	
}

}
