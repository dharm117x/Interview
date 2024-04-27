package com.java8.programs;


public class MyClass implements Inteface, Interface1, Interface2 {

	@Override
	public void method1() {
		System.out.println("MyClass.method1()");
	}

	@Override
	public void method2() {
		System.out.println("MyClass.method2()");
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
	}
	
	public static void main(String[] args) {
		MyClass obj = new MyClass();
		obj.log("Test");
		obj.method1();
		obj.method2();
		
	}
}