package com.masai.exceptionhandler;

public class InvalidRollNumberException extends RuntimeException {

	public InvalidRollNumberException() {
		
	}
	
	public InvalidRollNumberException(String s) {
		super(s);
	}
}
