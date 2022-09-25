package com.masai.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(InvalidProductId.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(InvalidProductId ie, WebRequest wr) {
		
		MyErrorDetails mer = new MyErrorDetails();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(ie.getMessage());
		mer.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(ProductException ie, WebRequest wr) {

		MyErrorDetails mer = new MyErrorDetails();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(ie.getMessage());
		mer.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.NOT_ACCEPTABLE);
	}
	
}
