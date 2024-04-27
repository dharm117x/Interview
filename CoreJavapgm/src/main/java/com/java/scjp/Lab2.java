package com.java.scjp;

public class Lab2 {
	static final int[] a = { 1, 2 }; // ok

	static final int[] b;
	static {
		// b= {1,2}; Array constants can only be used in initializers
		b = new int[2];
		b[0] = 100;
		b[1] = 200;
	}

	static int[] z;
	static {
		z[0] = 00; // java.lang.ExceptionInInitializerError
	}
//  static final int[] c= new int[2] {11,22}; //nok
	static final int[] c = new int[] { 11, 22 }; // ok

	static int[] d; // final not valid

	private void init() {
		d = new int[3];
		d[0] = 199;
		d[1] = 44;
	}

	int x[] = { 1, 2, 3, 4 };
	int y[] = x;
	{
		System.out.println(y[2]);
	}

	public static void main(String[] args) {
		System.out.println("Lab2.main()");
	}

}
