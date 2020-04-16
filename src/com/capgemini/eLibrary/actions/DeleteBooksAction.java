package com.capgemini.eLibrary.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.DAO.BooksDAO;
import com.capgemini.eLibrary.DAO.BooksDAOImpl;
import com.capgemini.eLibrary.dto.Book;
import com.capgemini.eLibrary.exceptions.DeleteBooksException;
import com.capgemini.eLibrary.forms.DeleteBooksForm;

public class DeleteBooksAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession ses = request.getSession(true);
		DeleteBooksForm deleteBooksForm = (DeleteBooksForm)form;
		
        BooksDAO booksDAO = new BooksDAOImpl();
        
        Book book= new Book();
       

        	int bookId = Integer.parseInt(deleteBooksForm.getBookId());
        	System.out.println(bookId);
        	
        	System.out.println("book returned" + book);
        	try {
        		book=booksDAO.deleteBooksById(deleteBooksForm);
        		ses.setAttribute("bookname", book.getBookname());
        		ses.setAttribute("author", book.getAuthor());
        		return mapping.findForward("deletion_successful");
        	}
        	catch(SQLException|DeleteBooksException e){
        		ses.setAttribute("exception", e.getMessage());
        		return mapping.findForward("deletion_failed");
        	}
        	
        	
        		
       
	}
	
}
