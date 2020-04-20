package com.capgemini.eLibrary.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.DAO.BooksDAO;
import com.capgemini.eLibrary.DAO.BooksDAOImpl;
import com.capgemini.eLibrary.constants.MessageConstant;
import com.capgemini.eLibrary.dto.Book;
import com.capgemini.eLibrary.forms.SearchBooksForm;

public class SearchBooksAction extends Action {

	static final Logger LOGGER = Logger.getLogger(SearchBooksAction.class);

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
			if (books.size() == 0) {
				LOGGER.error(MessageConstant.IN_SEARCH_BOOKS_ACTION + MessageConstant.NO_BOOKS_FOUND);
				throw new Exception(MessageConstant.NO_BOOKS_FOUND);
			}
			LOGGER.info(MessageConstant.IN_SEARCH_BOOKS_ACTION+"\n");
			for (Book b : books)
				LOGGER.info(b+"\n");
			session.setAttribute(MessageConstant.BOOKS_ATTRIBUTE, books);
			return mapping.findForward(MessageConstant.LIST_DISPLAY_SUCCESSFUL);
		} catch (Exception exception) {
			LOGGER.error(MessageConstant.IN_SEARCH_BOOKS_ACTION + exception.getMessage());
			request.setAttribute(MessageConstant.ERROR_MSG_ATTRIBUTE, exception.getMessage());
			return mapping.findForward(MessageConstant.LIST_DISPLAY_FAILED);
		}
	}
}
