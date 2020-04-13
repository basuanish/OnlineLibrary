package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.eLibrary.dto.Books;
import com.capgemini.eLibrary.utils.DBUtilis;

public class BooksDAOImpl implements BooksDAO {

	@Override
	public String addBooks(Books books) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement0 = null, preparedStatement = null;
		String staffID=null;
		
		try {
			connection = DBUtilis.getConnection();
			String query = "select * from STAFF_MEMBERS";
			preparedStatement0 = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement0.executeQuery();
			int rows = resultSet.getFetchSize()+1;
			String primaryKey="S"+rows;
			
			query = "INSERT INTO Books VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, books.getSerialnumber());
			preparedStatement.setString(2, books.getBookname());
			preparedStatement.setString(3, books.getAuthor());
			preparedStatement.setString(4, books.getQuantity());
		}
		catch (SQLException exception){
			throw (exception);
		}finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closePreparedStatement(preparedStatement0);
			DBUtilis.closeConnection(connection);
		}
		return "book added successfully";
	}

}
