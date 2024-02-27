package com.java.multithreading;

class Thread1 extends Thread {

	SharedDataPrinter p;

	// Thread
	public Thread1(SharedDataPrinter p) {

		// This keyword refers to current instance itself
		this.p = p;
	}

	// run() method for this thread invoked as
	// start() method is called in the main() method
	public void run() {

		// Print statement
		p.display("Geeks");
	}
}

// Class 2 (similar to class 1)
// Helper class extending the Thread class
class Thread2 extends Thread {

	SharedDataPrinter p;

	public Thread2(SharedDataPrinter p) {
		this.p = p;
	}

	public void run() {

		// Print statement
		p.display(" for Geeks");
	}
}

public class PrinterTest {
	public static void main(String[] args) {
		SharedDataPrinter printer = new SharedDataPrinter();

		// Thread objects sharing data printer
		Thread1 t1 = new Thread1(printer);
		Thread2 t2 = new Thread2(printer);

		// Calling start methods for both threads
		// using the start() method
		t1.start();
		t2.start();
	}
}
