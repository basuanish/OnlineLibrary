package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.utils.DBUtilities;

public class StaffDAOImpl implements StaffDAO{

	@Override
	public boolean existsByUsername(String username) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean staffExists = false;

		try {
			connection = DBUtilities.getConnection();
			String query = "select * from STAFF_MEMBERS where USER_NAME=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				staffExists = true;
			}
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilities.closePreparedStatement(preparedStatement);
			DBUtilities.closeConnection(connection);
		}
		return staffExists;
	}

	@Override
	public boolean existsByPhoneNo(String phoneNo) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean staffExists = false;

		try {
			connection = DBUtilities.getConnection();
			String query = "select * from STAFF_MEMBERS where PHONENO=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phoneNo);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				staffExists = true;
			}
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilities.closePreparedStatement(preparedStatement);
			DBUtilities.closeConnection(connection);
		}
		return staffExists;
	}
	
	@Override
	public String addStaffRow(StaffMember staffMember) throws SQLException{
	
		Connection connection = null;
		PreparedStatement preparedStatement0 = null, preparedStatement = null;
		/*
		 * 	STAFF_ID VARCHAR(10),
		    STAFF_NAME VARCHAR(30),
		    USER_NAME VARCHAR(20) UNIQUE NOT NULL,
		    PASS VARCHAR(20) NOT NULL,
		    PHONENO VARCHAR(10) UNIQUE NOT NULL,
		    ADDRESS VARCHAR(1000),
		    DESIGNATION VARCHAR(20) NOT NULL
		 */
		try {
			connection = DBUtilities.getConnection();
			String query = "select * from STAFF_MEMBERS";
			preparedStatement0 = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement0.executeQuery();
			int rows = resultSet.getFetchSize()+1;
			String primaryKey="S"+rows;
			
			query = "INSERT INTO STAFF_MEMBERS VALUES (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, primaryKey);
			preparedStatement.setString(2, staffMember.getName());
			preparedStatement.setString(3, staffMember.getUsername());
			preparedStatement.setString(4, staffMember.getPassword());
			preparedStatement.setString(5, staffMember.getPhoneNo());
			preparedStatement.setString(6, staffMember.getAddress());
			preparedStatement.setString(7, staffMember.getDesignation());
			resultSet = preparedStatement.executeQuery();
			
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilities.closePreparedStatement(preparedStatement0);
			DBUtilities.closePreparedStatement(preparedStatement);
			DBUtilities.closeConnection(connection);
		}
		return "New staff member created";
	}
}
