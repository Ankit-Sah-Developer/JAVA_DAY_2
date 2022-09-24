package com.masai.exceptionhandler;

@SuppressWarnings("serial")
public class BookNotFound extends RuntimeException{
	
	public BookNotFound() {
		// TODO Auto-generated constructor stub
	}
	
	public BookNotFound(String msg) {
		super(msg);
	}
}
