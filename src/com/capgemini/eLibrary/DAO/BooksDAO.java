package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;

import com.capgemini.eLibrary.dto.Books;

public interface BooksDAO {

	String addBooks(Books books) throws SQLException;
	Books deleteBooksById(int bookId) throws SQLException;
	Books findById(int staffId)throws SQLException;
	
}
