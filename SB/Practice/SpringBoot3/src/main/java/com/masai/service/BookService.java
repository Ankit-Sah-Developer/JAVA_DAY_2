package com.masai.service;

import java.util.List;

import com.masai.exceptionhandler.BookNotFound;
import com.masai.model.Book;
import com.masai.model.BookDTO;

public interface BookService {
	
	public List<Book> getAllBooks() throws BookNotFound;
	
	public Book getBookById(Integer bookId) throws BookNotFound;
	
	public List<BookDTO> getAllBooksDTO() throws BookNotFound;
	
	public BookDTO getBookDTOById(Integer bookId) throws BookNotFound;
	
	public Book createBook(Book book);
	
	public String deleteBook(Integer bookId) throws BookNotFound;
	
	public Book updateBook(Book book, Integer bookId) throws BookNotFound; 

}
