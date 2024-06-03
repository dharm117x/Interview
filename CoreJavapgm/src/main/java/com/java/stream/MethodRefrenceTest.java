package com.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MethodRefrenceTest {
	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();
		list.add(new Employee(2, "B", 2000));
		list.add(new Employee(1, "A", 1000));
		list.add(new Employee(4, "D", 4000));
		list.add(new Employee(3, "C", 3000));

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

		String str = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		System.out.print(str);
		
		System.out.println("\n-----------");
		List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);
		numbers.stream().sorted(Integer::compareTo).forEach(System.out::print);
		System.out.println("\n-----------");
		numbers.stream().sorted(Integer::compareTo).forEach(p -> System.out.print(p + " "));
		System.out.println("\n-----------");

		list.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
		System.out.println("\n-----------");
		
		list.stream().sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);

	}
}
