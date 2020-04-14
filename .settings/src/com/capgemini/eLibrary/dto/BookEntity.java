package com.capgemini.eLibrary.dto;

public class BookEntity {
	private String bookId;
	private String bookName;
	private String author;
	private boolean issued;
	
	
	public BookEntity() {
		super();
		
	}


	public BookEntity(String bookId, String bookName, String author, boolean issued) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.issued = issued;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
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


	public boolean isIssued() {
		return issued;
	}


	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	

}
