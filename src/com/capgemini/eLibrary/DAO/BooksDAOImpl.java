package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.eLibrary.dto.Books;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.utils.DBUtilis;

public class BooksDAOImpl implements BooksDAO {

	@Override
	public String addBooks(Books books) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement0 = null, preparedStatement = null;
		
		
		try {

			
			connection = DBUtilis.getInstance().getConnection();
			String query = "select * from Books";
			preparedStatement0 = connection.prepareStatement(query);
			preparedStatement0.executeQuery();
			
			query = "INSERT INTO Books (bookname,author,issued) VALUES (?,?,?)";

			connection = DBUtilis.getConnection();
			String query = "select * from Books";
			preparedStatement0 = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement0.executeQuery();
			int rows = resultSet.getFetchSize()+1;
			
			
			query = "INSERT INTO Books VALUES (?,?)";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, books.getBookname());
			preparedStatement.setString(2, books.getAuthor());
			preparedStatement.setBoolean(3, false);
			preparedStatement.executeUpdate();

		}
		catch (SQLException exception){
			throw (exception);
		}finally {

//			DBUtilis.closePreparedStatement(preparedStatement);
//			DBUtilis.closePreparedStatement(preparedStatement0);
//			DBUtilis.closeConnection(connection);
			preparedStatement.close();
			preparedStatement0.close();
			connection.close();
		}
		return "book added successfully";
	}

	@Override
	public Books deleteBooksById(int bookId) throws SQLException {
		Books booksDeleted=null;
		try {
			booksDeleted = findById(bookId);
		}catch(SQLException exception) {
			throw (exception);
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getConnection();
			String query = "delete from Books where bookId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bookId);
			preparedStatement.executeUpdate();
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
		return booksDeleted;
	}

	@Override
	public Books findById(int bookId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Books books=null;
		
		try {
			connection = DBUtilis.getConnection();
			String query = "select * from Books where bookId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				books=new Books();
				books.setBookId(resultSet.getInt(1));
				books.setBookname(resultSet.getString(2));
				books.setAuthor(resultSet.getString(3));
			}
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
		return books;
	}
	}


