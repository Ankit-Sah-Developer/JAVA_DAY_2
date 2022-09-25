package com.masai.exceptionHandler;

public class ProductException extends RuntimeException{
	
	public ProductException (){
		
	}
	
	public ProductException (String s){
		super(s);
	}
}
