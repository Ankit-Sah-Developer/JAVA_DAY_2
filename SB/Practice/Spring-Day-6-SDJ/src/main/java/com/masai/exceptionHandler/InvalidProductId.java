package com.masai.exceptionHandler;

public class InvalidProductId extends RuntimeException{

	public InvalidProductId(){
		
	}
	
	public InvalidProductId(String s) {
		super(s);
	}
}
