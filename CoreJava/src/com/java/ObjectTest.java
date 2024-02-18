package com.java;

import java.lang.reflect.InvocationTargetException;

public class ObjectTest {
@SuppressWarnings("deprecation")
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	Employee e = new Employee();
	System.out.println(e);
	Class<?> cls = Class.forName("com.java.Employee");
	
	Object obj1 = cls.newInstance();
	System.out.println(obj1);
	
	Object obj2 = cls.getDeclaredConstructor().newInstance();
	System.out.println(obj2);
	
}
}
