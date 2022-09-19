package com.masai.Q1;

public class BookNotFoundException extends RuntimeException{

	public BookNotFoundException() {
		
	}
	public BookNotFoundException(String s) {
		super(s);
	}
}
