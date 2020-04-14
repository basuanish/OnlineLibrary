package com.capgemini.eLibrary.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SearchBooksForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5760463950740174321L;
	private String bookname;
	private String author;
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors=new ActionErrors();
		if(bookname.length() < 1  && author.length() < 1)
			actionErrors.add("bookname",new ActionMessage("error.booknameOrAuthor.required"));
		return actionErrors;
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
}
