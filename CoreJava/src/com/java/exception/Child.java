package com.java.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent{

	// Throws in child methods signature is same or subclass of exception and throws any runtime exception but not required.
	@Override
	public void name() throws IOException, FileNotFoundException, RuntimeException {

	}
}
