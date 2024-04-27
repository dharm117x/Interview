package com.java.multithreading;

public class  SharedDataPrinter {
	 
    // Method (synchronised)
    public synchronized void display(String str)
    {   System.out.println("");
    	System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < str.length(); i++) {
        	  System.out.print(str.charAt(i));
 
            // Try-catch block for exceptions as we are
            // using sleep() method
            try {
 
                // Making thread to sleep for very
                // nanoseconds as passed in the arguments
                Thread.sleep(100);
            }
            catch (Exception e) {
            }
        }
    }
}
