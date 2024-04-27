package com.java;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ProductExtr implements Externalizable {

	String name;
	int price;
	int size;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(price);
		out.writeInt(size);
		out.flush();
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		String name = (String) in.readObject();
		int price = in.readInt();
		int size = in.readInt();
		System.out.println("Name::-"+name);
		System.out.println("Price::-"+price);
		System.out.println("size::-"+size);
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fo = new FileOutputStream("product.txt");
		FileInputStream fi = new FileInputStream("product.txt");

		ProductExtr p = new ProductExtr();
		p.name= "ASD";
		p.price = 1000;
		p.size=10;

		p.writeExternal(new ObjectOutputStream(fo));
		p.readExternal(new ObjectInputStream(fi));

	}

}
