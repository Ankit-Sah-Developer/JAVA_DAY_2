package com.masai.exceptionhandler;

public class StudentException extends RuntimeException{

	public StudentException() {
		
	}
	
	public StudentException(String s) {
		super(s);
	}
}
