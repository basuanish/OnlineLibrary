package com.capgemini.eLibrary.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.DAO.IssueBookDAO;
import com.capgemini.eLibrary.DAO.IssueBookDAOImpl;
import com.capgemini.eLibrary.dto.BookEntity;
import com.capgemini.eLibrary.exceptions.InvalidBookException;
import com.capgemini.eLibrary.forms.IssueBookForm;

public class IssueBookAction extends org.apache.struts.action.Action{
	
	 @Override
	    public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 IssueBookForm issueForm = (IssueBookForm)form;
		 HttpSession session = request.getSession(true);
	     IssueBookDAO dao = new IssueBookDAOImpl();
	     BookEntity book = new BookEntity();
	     
	     try {
	    	 book = dao.issueBook(issueForm);
	    	 request.setAttribute("bookId", book.getBookId());
	    	 request.setAttribute("book name", book.getBookName());
	    	 request.setAttribute("author", book.getAuthor());
	    	 request.setAttribute("issued", book.isIssued());
	    	 return mapping.findForward("success");
	     }
	     
	     catch(InvalidBookException | SQLException e) {
	    	 request.setAttribute("exception", e.getMessage());
	    	 return mapping.findForward("failure");
	    	 
	     }
}
}
