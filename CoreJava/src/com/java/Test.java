package com.java;

public class Test {
public static void main(String[] args) {
	final String x="a";
	Runnable r =()->System.out.println(x);
	//x="b";
    r.run();
  }
}
