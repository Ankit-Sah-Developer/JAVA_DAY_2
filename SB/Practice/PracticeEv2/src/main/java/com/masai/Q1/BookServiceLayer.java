package com.masai.Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class BookServiceLayer {
	
	public static List<Book> b = new ArrayList<>();
	
	public static List<Book> books(){
		
		b.add(new Book(101, "HP1", "JKR", 1000));
		b.add(new Book(102, "Bahubali", "RajaMauli", 1200));
		b.add(new Book(103, "DSA", "Ankush", 3000));
		b.add(new Book(104, "JAVA", "Ratan", 4400));
		b.add(new Book(105, "Power_Skills", "Yogesh", 2000));
		return b;
	}

	
	
	public List<Book> getBooks() {
		
		return books();
	}
	
	public Book getBookByID(int id) {
		
		Book bk = null;
		
		for(Book b:books()) {
			if(b.getBook_id() == id) {
				bk = b;
			}
		}
		if(bk == null) {
			throw new BookNotFoundException("Book not Found with Id");
		}else
		return bk;
	}
	
	public String addBook(Book b) {
		
		String s = "Not Added";
		
		if(b!=null) {
			books().add(b);
			s = "Book Added Success..";
		}
		else {
			throw new NullValueErrorException("Book value is null");
		}
		
		return s;
	}
	
	public String deleteBook(int id) {
		
		String s = "Not Deleted";
		
		Book bk = null;
		
		for(Book b:books()) {
			if(b.getBook_id() == id) {
				bk = b;
			}
		}
		if(bk == null) {
			throw new BookNotFoundException("Book not Found with Id: "+ id);
		}else {
			books().remove(bk);
			s = "Book Deleted..";
		}
		return s;
	}
}
