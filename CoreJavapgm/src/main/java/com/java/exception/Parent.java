package com.java.exception;

import java.io.IOException;

public class Parent {

	public void name() throws IOException,NullPointerException {
		throw new IllegalArgumentException("Not valid");
	}
}
