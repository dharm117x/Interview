package com.java;

public class JavaTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("enclosing_type.enclosing_method()");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			String str= new String("Hello World");
			
			@Override
			public void run() {
				System.out.println("Inside Add Shutdown Hook");
				
				setStr(null);
				Runtime.getRuntime().gc();
			}

			public void setStr(String str) {
				this.str = str;
			}
		});
		
		Thread.sleep(5000);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("JavaTest.finalize()");
	}
}
