package com.capgemini.eLibrary.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddBooksForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors ae = new ActionErrors();
		
		if(serialnumber==null || serialnumber.length() !=5 || serialnumber.length() <1)
		ae.add("serialnumber", new ActionMessage("error.serialnumber.required"));
		
		if(bookname==null || bookname.length() <1)
			ae.add("bookname", new ActionMessage("error.bookname.required"));
		
		if(!bookname.matches("[A-Z][a-z]* [[A-Z][a-z]*]"))
			ae.add("bookname", new ActionMessage("error.bookname.invalid"));
		
		if(author==null || author.length() <1)
			ae.add("author", new ActionMessage("error.author.required"));
		
		if(!author.matches("[A-Z][a-z]* [[A-Z][a-z]*]"))
			ae.add("author", new ActionMessage("error.author.invalid"));
		
		if(quantity==null || !quantity.matches("[0-9]"))
			ae.add("author", new ActionMessage("error.quantity.invalid"));
		
		
		return ae;
	}
	

}
