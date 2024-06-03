package com.java.exception;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	String message;
	
	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}
	
}
