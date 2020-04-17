package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.eLibrary.dto.Book;
import com.capgemini.eLibrary.exceptions.DeleteBooksException;
import com.capgemini.eLibrary.forms.DeleteBooksForm;

public interface BooksDAO {

	String addBooks(Book book) throws SQLException;
	Book deleteBooksById(DeleteBooksForm deleteBooksForm) throws SQLException, DeleteBooksException;
	Book findById(int staffId)throws SQLException;
	List<Book> findByTitleOrAuthor(Book book) throws SQLException;
}
