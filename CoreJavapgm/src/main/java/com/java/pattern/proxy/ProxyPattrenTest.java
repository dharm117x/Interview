package com.java.pattern.proxy;

public class ProxyPattrenTest {
	public static void main(String[] args) {
		Image image = new ProxyImage("testImage.jpg");

		// Image will be loaded from disk
		image.display();
		System.out.println("");

		// Image will not be loaded from disk
		image.display();
	}
}
