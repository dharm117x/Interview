package com.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(2, "B", 2000));
		list.add(new Employee(1, "A", 1000));
		list.add(new Employee(4, "D", 4000));
		list.add(new Employee(3, "C", 3000));

		list.stream().filter(e -> e.salary < 3000).map(e -> (e.salary = e.salary * 110 / 100))
				.forEach(c -> System.out.println(c));

		list.stream().filter(e -> e.salary < 3000).forEach(c -> {
			c.setSalary(c.salary * 110 / 100);
			System.out.println(c);
		});

	}
}
