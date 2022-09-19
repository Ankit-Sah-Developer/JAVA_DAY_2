package com.masai.Q1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	public BookServiceLayer bsl;
	
	
	@GetMapping("/books")
	public List<Book> getAllbooks(){
		
		return bsl.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id) {
		
		return bsl.getBookByID(id);
	}
	
	@PostMapping(value = "/book")
	public String saveBook(Book b) {
		
		return bsl.addBook(b);
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable int id) {
		
		return bsl.deleteBook(id);
	}
}
