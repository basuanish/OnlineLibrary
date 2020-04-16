package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.DAO.BooksDAO;
import com.capgemini.eLibrary.DAO.BooksDAOImpl;
import com.capgemini.eLibrary.dto.Book;
import com.capgemini.eLibrary.forms.DeleteBooksForm;

public class DeleteBooksAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DeleteBooksForm deleteBooksForm = (DeleteBooksForm)form;
        BooksDAO booksDAO = new BooksDAOImpl();
        
        Book book= new Book();
       

        	int bookId = Integer.parseInt(deleteBooksForm.getBookId());
        	System.out.println(bookId);
        	book=booksDAO.deleteBooksById(bookId);
        	System.out.println("book returned" + book);
        	if(book != null)
        	return mapping.findForward("deletion_successful");
        	else
        	return mapping.findForward("deletion_failed");
        		
       
	}
	
}
