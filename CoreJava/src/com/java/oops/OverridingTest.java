package com.java.oops;

public class OverridingTest {
public static void main(String[] args) throws Exception {
	Parent p= new Child();
	p.m1();
	p=null;
	p.m2();
}
}
