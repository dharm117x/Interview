package com.java;

public class JavaTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("enclosing_type.enclosing_method()");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Inside Add Shutdown Hook");
				Runtime.getRuntime().gc();
			}
		});
		
		Thread.sleep(1000);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("JavaTest.finalize()");
	}
}
