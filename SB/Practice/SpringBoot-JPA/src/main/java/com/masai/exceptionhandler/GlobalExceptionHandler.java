package com.masai.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(StudentException se , WebRequest wr){
		
		MyErrorDetails mer = new MyErrorDetails();
		mer.setTimestamp(LocalDateTime.now());
		mer.setMessage(se.getMessage());
		mer.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(mer, HttpStatus.BAD_REQUEST);
		
	}
}
