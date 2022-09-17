package com.masai.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidRollNumberException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(InvalidRollNumberException ie, WebRequest wr) {

		System.out.println("Inside myExceptionHandler method..");

		MyErrorDetails mer = new MyErrorDetails();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(ie.getMessage());
		mer.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.BAD_REQUEST);

	}

//	to handle Not found exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest wr) {
		
		MyErrorDetails mer = new MyErrorDetails();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(nfe.getMessage());
		mer.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(mer, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler2(Exception e, WebRequest wr) {

		System.out.println("Inside myExceptionHandler2 method..");

		MyErrorDetails mer = new MyErrorDetails();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(e.getMessage());
		mer.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.BAD_REQUEST);

	}
}
