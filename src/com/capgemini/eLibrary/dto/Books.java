package com.capgemini.eLibrary.dto;

public class Books {

	private String serialnumber;
	private String bookname;
	private String author;
	private String quantity;
	
	
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Books(String serialnumber, String bookname, String author, String quantity) {
		super();
		this.serialnumber = serialnumber;
		this.bookname = bookname;
		this.author = author;
		this.quantity = quantity;
	}
	
	
	
}
