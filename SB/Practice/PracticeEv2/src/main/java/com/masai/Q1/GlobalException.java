package com.masai.Q1;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyError> myExceptionHandler(BookNotFoundException bnf, WebRequest wr) {
		
		MyError mer = new MyError();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(bnf.getMessage());
		mer.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyError>(mer, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullValueErrorException.class)
	public ResponseEntity<MyError> myExceptionHandler(NullValueErrorException nve, WebRequest wr) {
		
		MyError mer = new MyError();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(nve.getMessage());
		mer.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyError>(mer, HttpStatus.BAD_REQUEST);
	}

}
