package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.eLibrary.dto.Book;
import com.capgemini.eLibrary.exceptions.DeleteBooksException;
import com.capgemini.eLibrary.forms.DeleteBooksForm;
import com.capgemini.eLibrary.utils.DBUtilis;

public class BooksDAOImpl implements BooksDAO {

	@Override
	public String addBooks(Book book) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DBUtilis.getInstance().getConnection();

			String query = "INSERT INTO Books (bookname,author,issued) VALUES (?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, book.getBookname());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setBoolean(3, false);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw (exception);
		} finally {


			preparedStatement.close();
			connection.close();
		}
		return "book added successfully";
	}

	@Override
	public Book deleteBooksById(DeleteBooksForm deleteBooksForm) throws SQLException, DeleteBooksException {
		Book booksDeleted = new Book();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int bookId=Integer.parseInt(deleteBooksForm.getBookId());
		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = "select * from Books where bookId=?";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Bookid"+bookId);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
			
				
				String query1 = "delete from Books where bookId=?";
				preparedStatement = connection.prepareStatement(query1);
				preparedStatement.setInt(1, bookId);
				int rowsAffected=preparedStatement.executeUpdate();
				System.out.println(rowsAffected);
			} else {
				throw new DeleteBooksException("Invalid Id");
			}
		} catch (SQLException exception) {
			throw (exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return booksDeleted;
	}

	@Override
	public Book findById(int bookId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Book book = new Book();

		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = "select * from Books where bookId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				
				book.setBookId(resultSet.getInt(1));
				book.setBookname(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
			}
		} catch (SQLException exception) {
			throw (exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		System.out.println("retrieved book" + book);
		return book;
	}

	@Override
	public List<Book> findByTitleOrAuthor(Book book) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		List<Book> books = new ArrayList<>();
		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = "select * from Books where bookname= ? OR author = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, book.getBookname());
			preparedStatement.setString(2, book.getAuthor());
			ResultSet resultSet = preparedStatement.executeQuery();
			Book singleBook;
			while (resultSet.next()) {
				singleBook = new Book();
				singleBook.setBookId(resultSet.getInt(1));
				singleBook.setBookname(resultSet.getString(2));
				singleBook.setAuthor(resultSet.getString(3));
				books.add(singleBook);
			}
		} catch (SQLException exception) {
			throw (exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return books;
	}

}
