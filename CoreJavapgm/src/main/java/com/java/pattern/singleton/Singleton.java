package com.java.pattern.singleton;

public class Singleton {
	// Step 2: Create a private static instance of the class.
    private static Singleton uniqueInstance;

    // Step 1: Declare the constructor as private.
    private Singleton() {
        // This will prevent instantiation from other classes.
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException("Clone Not supported");
    }

    // Step 3: Provide a public static method to return the instance of the class.
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
        	System.out.println(Thread.currentThread().getName());
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
