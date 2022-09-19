package com.masai.Q1;

public class Book {

	private int book_id;
	private String name;
	private String author;
	private int price;

	public Book() {
		super();
	}

	public Book(int book_id, String name, String author, int price) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

	
}
