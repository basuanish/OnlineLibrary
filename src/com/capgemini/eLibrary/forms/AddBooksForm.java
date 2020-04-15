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

	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors ae = new ActionErrors();
		
	
		
		if(bookname==null | bookname.equals(""))
			ae.add("bookname", new ActionMessage("error.bookname.required"));
		

		
		if(author==null | author.equals(""))
			ae.add("author", new ActionMessage("error.author.required"));
		

		
		
		return ae;
	}
	

}
