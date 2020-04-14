package com.capgemini.eLibrary.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class IssueBookForm extends ActionForm{

	private static final long serialVersionUID = 4234794995282881014L;
	private String bookId;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		if (bookId == null || bookId.length() < 1) {
			errors.add("bookId", new ActionMessage("error.bookId.required"));
		}
		String regex = "\\d+";
			
		if(!bookId.matches(regex)) {
			errors.add("bookId", new ActionMessage("error.bookId.number"));
		}
	return errors;

	
}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}