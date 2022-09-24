package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptionhandler.BookNotFound;
import com.masai.model.Author;
import com.masai.model.Book;
import com.masai.model.BookDTO;
import com.masai.repository.AuthorDAO;
import com.masai.repository.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;
	
	@Autowired
	private AuthorDAO authorDao;

	@Override
	public List<Book> getAllBooks() throws BookNotFound {

		List<Book> books = bookDao.findAll();

		if (books.isEmpty())
			throw new BookNotFound("No book records found");

		return books;

	}

	@Override
	public Book getBookById(Integer bookId) throws BookNotFound {

		Optional<Book> book = bookDao.findById(bookId);

		return book.orElseThrow(() -> new BookNotFound("No book records found"));
	}
	
	@Override
	public List<BookDTO> getAllBooksDTO() throws BookNotFound {

		List<Book> books = bookDao.findAll();

		if (books.isEmpty())
			throw new BookNotFound("No book records found");
		
		List<BookDTO> bts = new ArrayList<>();
		
		for(Book b:books) {
			BookDTO bt = new BookDTO();
			bt.setName(b.getName());
			bt.setAuthor(b.getAuthor().getName());
			bt.setCategory(b.getCategory());
			bt.setPublication(b.getPublication());
			bt.setPrice(b.getPrice());
			bt.setPages(b.getPages());
			bts.add(bt);
		}

		return bts;

	}

	@Override
	public BookDTO getBookDTOById(Integer bookId) throws BookNotFound {

		Optional<Book> book = bookDao.findById(bookId);

		if (!book.isPresent())
			throw new BookNotFound("No book records found");
		
		Book b = book.get();
		
		BookDTO bt = new BookDTO();
		bt.setName(b.getName());
		bt.setAuthor(b.getAuthor().getName());
		bt.setCategory(b.getCategory());
		bt.setPublication(b.getPublication());
		bt.setPrice(b.getPrice());
		bt.setPages(b.getPages());
		
		return bt;
		
	}

	@Override
	@Transactional
	public Book createBook(Book book) {
		
		Author a = authorDao.findByName(book.getAuthor().getName());
		if(a != null) {
			a.getBooks().add(book);
			authorDao.save(a);
			return book;
		}
		return bookDao.save(book);

	}

	@Override
	public String deleteBook(Integer bookId) throws BookNotFound {

		Optional<Book> book = bookDao.findById(bookId);

		if (!book.isPresent())
			throw new BookNotFound("No book records found");

		bookDao.delete(book.get());

		return "Book deleted succefully with ID" + bookId;

	}

	@Override
	@Transactional
	public Book updateBook(Book book, Integer bookId) throws BookNotFound {

		Optional<Book> o_book = bookDao.findById(bookId);

		if (!o_book.isPresent())
			throw new BookNotFound("No book records found");

		Book eBook = o_book.get();
		eBook.setName(book.getName());
		eBook.setAuthor(book.getAuthor());
		eBook.setCategory(book.getCategory());
		eBook.setPublication(book.getPublication());
		eBook.setPages(book.getPages());
		eBook.setPrice(book.getPrice());
		
		Author author = new Author();
		author.setName(eBook.getAuthor().getName());
		author.setAge(eBook.getAuthor().getAge());
		author.setAddress(eBook.getAuthor().getAddress());
		author.getBooks().add(eBook);
		
		authorDao.save(author);

		return bookDao.save(eBook);

	}

}
