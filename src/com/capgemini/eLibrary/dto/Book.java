package com.capgemini.eLibrary.dto;

public class Book {

	private String bookname;
	private String author;
	private int bookId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(String bookname, String author) {
		super();

		this.bookname = bookname;
		this.author = author;
	}

	public Book() {

	}

	@Override
	public String toString() {
		return "Book [bookname=" + bookname + ", author=" + author + ", bookId=" + bookId + "]";
	}

	
}
