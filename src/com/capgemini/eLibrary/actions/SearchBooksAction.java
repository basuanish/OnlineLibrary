package com.capgemini.eLibrary.actions;

import java.util.List;

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
import com.capgemini.eLibrary.forms.SearchBooksForm;

public class SearchBooksAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		SearchBooksForm searchBooksForm = (SearchBooksForm) form;
		BooksDAO booksDAO = new BooksDAOImpl();

		Book searchBook = new Book();
		searchBook.setBookname(searchBooksForm.getBookname());
		searchBook.setAuthor(searchBooksForm.getAuthor());
		List<Book> books;
		try {
			books = booksDAO.findByTitleOrAuthor(searchBook);
			if(books.size()==0)
				throw new Exception("No books found with the given criteria!!!");
			for(Book b:books)
				System.out.println(b);
			session.setAttribute("books", books);
			return mapping.findForward("list display successful");
		} catch (Exception exception) {
			request.setAttribute("errorMsg", exception.getMessage());
			return mapping.findForward("list display failed");
		}
	}
}
