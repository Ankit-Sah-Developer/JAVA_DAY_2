package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.model.BookDTO;
import com.masai.service.BookService;

@RestController
@RequestMapping("/bookservice/reader")
public class ReaderController {
	
	@Autowired
	private BookService bookSer;

	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> getAllBooks() {

		return new ResponseEntity<List<BookDTO>>(bookSer.getAllBooksDTO(), HttpStatus.OK);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Integer id) {

		return new ResponseEntity<BookDTO>(bookSer.getBookDTOById(id), HttpStatus.OK);

	}
}
