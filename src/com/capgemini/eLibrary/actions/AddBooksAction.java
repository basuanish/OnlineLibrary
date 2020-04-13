package com.capgemini.eLibrary.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.capgemini.eLibrary.DAO.BooksDAO;
import com.capgemini.eLibrary.DAO.BooksDAOImpl;
import com.capgemini.eLibrary.dto.Books;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.forms.AddBooksForm;

public class AddBooksAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession ses = request.getSession(true);
		
		AddBooksForm addBooksForm = (AddBooksForm) form;
		String serialnumber = addBooksForm.getSerialnumber();
        String bookname = addBooksForm.getBookname();
        String author = addBooksForm.getAuthor();
        String quantity = addBooksForm.getQuantity();
        Books books = new Books(serialnumber,bookname,author,quantity);
        BooksDAO booksDAO = new BooksDAOImpl() ;
        booksDAO.addBooks(books);
        ses.setAttribute("serialnumber", serialnumber);
        ses.setAttribute("bookname", bookname);
        ses.setAttribute("author", author);
        ses.setAttribute("quantity", quantity);
        return mapping.findForward("addBooksSucces");
	
	}
	}
