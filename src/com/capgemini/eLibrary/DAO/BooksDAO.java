package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;
import java.util.List;

import com.capgemini.eLibrary.dto.Book;

public interface BooksDAO {

	String addBooks(Book book) throws SQLException;
	Book deleteBooksById(int bookId) throws SQLException;
	Book findById(int staffId)throws SQLException;
	List<Book> findByTitleOrAuthor(Book book) throws SQLException;
}
