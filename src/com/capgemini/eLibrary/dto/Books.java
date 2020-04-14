package com.capgemini.eLibrary.dto;

public class Books {


	private String bookname;
	private String author;

	
	
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

	public Books( String bookname, String author) {
		super();
	
		this.bookname = bookname;
		this.author = author;
	}
	
	
	
}
