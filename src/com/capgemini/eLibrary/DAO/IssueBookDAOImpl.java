package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.eLibrary.dto.BookEntity;
import com.capgemini.eLibrary.exceptions.InvalidBookException;
import com.capgemini.eLibrary.forms.IssueBookForm;
import com.capgemini.eLibrary.utils.DBUtilis;

public class IssueBookDAOImpl implements IssueBookDAO {

	@Override
	public BookEntity issueBook(IssueBookForm form) throws SQLException, InvalidBookException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BookEntity book = null;
		
		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = "select * from Books where bookId=? and issued=?";
			preparedStatement = connection.prepareStatement(query);
			int bookID=Integer.parseInt(form.getBookId());
			System.out.println("Bookid"+bookID);
			preparedStatement.setInt(1, bookID);
			preparedStatement.setBoolean(2, false);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
					
					String status_change = "update Books set issued = ? where bookId=?";
					preparedStatement = connection.prepareStatement(status_change);
					preparedStatement.setInt(2, bookID);
					preparedStatement.setBoolean(1, true);
					
					int rowsAffected = preparedStatement.executeUpdate();
					System.out.println(rowsAffected);
					
				book = new BookEntity();
				book.setBookId(Integer.toString(resultSet.getInt(1)));
				book.setBookName(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setIssued(true);
			}
			else {
				throw new InvalidBookException("No books found");
			}
		}
		catch(SQLException e) {
			throw new SQLException("No Database connection");
		}
		finally {
//			DBUtilis.closePreparedStatement(preparedStatement);
//			DBUtilis.closeConnection(connection);
			preparedStatement.close();
			connection.close();
		}
		return book;
	}

}
