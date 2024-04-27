package com.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProductSer implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	int price;
	int size;
	
	@Override
	public String toString() {
		return "ProductSer [name=" + name + ", price=" + price + ", size=" + size + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ProductSer ser = new ProductSer();
		ser.name="Moto";
		ser.price=100;
		ser.size=20;
		
		FileOutputStream fo = new FileOutputStream("product1.txt");
		FileInputStream fi = new FileInputStream("product1.txt");

		
		ObjectOutputStream out = new ObjectOutputStream(fo);
		out.writeObject(ser);
		out.flush();
		
		ObjectInputStream in = new ObjectInputStream(fi);
		ProductSer prod = (ProductSer) in.readObject();
		System.out.println(prod);
		
		out.close();
		in.close();
	}
}
