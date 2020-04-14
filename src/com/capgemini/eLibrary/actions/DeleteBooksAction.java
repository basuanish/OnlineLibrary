package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.DAO.BooksDAO;
import com.capgemini.eLibrary.DAO.BooksDAOImpl;
import com.capgemini.eLibrary.dto.Books;
import com.capgemini.eLibrary.forms.DeleteBooksForm;

public class DeleteBooksAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DeleteBooksForm deleteBooksForm = (DeleteBooksForm)form;
        BooksDAO booksDAO = new BooksDAOImpl();
        
        Books books= new Books();
        try
        {
        	books.setBookId(deleteBooksForm.getBookId());
        	int bookId = deleteBooksForm.getBookId();
        	books=booksDAO.deleteBooksById(bookId);
        	return mapping.findForward("deletion_successful");
        }
        catch (Exception e)
        {
        	return mapping.findForward("deletion_failed");
        }
	}
	
}
