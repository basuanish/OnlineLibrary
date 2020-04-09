package com.capgemini.eLibrary.dto;

public class Book {
	private String bookID;
	private String bookName;
	private String author;

	public Book() {

	}

	public Book(String bookName, String author) {
		this();
		this.bookName = bookName;
		this.author = author;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
