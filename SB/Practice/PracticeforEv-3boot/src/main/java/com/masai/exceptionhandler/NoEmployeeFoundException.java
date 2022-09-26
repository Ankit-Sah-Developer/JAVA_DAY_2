package com.masai.exceptionhandler;

@SuppressWarnings("serial")
public class NoEmployeeFoundException extends RuntimeException{
	
	public NoEmployeeFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public NoEmployeeFoundException(String msg) {
		super(msg);
	}
}
