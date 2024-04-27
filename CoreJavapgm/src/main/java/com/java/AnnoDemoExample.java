package com.java;

import com.java.annotaion.MyAnno;

public class AnnoDemoExample {
public static void main(String[] args) {
	AnnoDemo d = new AnnoDemo();
	Class<? extends AnnoDemo> c = d.getClass();
	MyAnno myAnno = c.getAnnotation(MyAnno.class);
	System.out.println(myAnno.myval());
	System.out.println(myAnno.city());
	System.out.println(myAnno.name());
}
}
