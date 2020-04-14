package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.utils.DBUtilis;

public class StaffDAOImpl implements StaffDAO{

	@Override
	public boolean existsByUsername(String username) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean staffExists = false;
		try {
			connection = DBUtilis.getConnection();
			String query = "select * from STAFF_MEMBERS where USER_NAME=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
	
			if (resultSet.next()) {
				staffExists = true;
			}
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
		}
		return staffExists;
	}

	@Override
	public boolean existsByPhoneNo(String phoneNo) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean staffExists = false;

		try {
			connection = DBUtilis.getConnection();
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
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
		return staffExists;
	}
	
	
	@Override
	public StaffMember createStaff(StaffMember staffMember) throws SQLException{
		try {
			addStaffRow(staffMember);
		}catch(SQLException exception) {
			throw (exception);
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getConnection();
			String query = "select * from STAFF_MEMBERS where USER_NAME=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, staffMember.getUsername());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				staffMember.setStaffID(rs.getInt(1));
			}
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
		return staffMember;
	}
	
	public void addStaffRow(StaffMember staffMember) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getConnection();
			String query = "INSERT INTO STAFF_MEMBERS (STAFF_NAME, USER_NAME, PASS, PHONENO, ADDRESS, DESIGNATION) VALUES (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, staffMember.getName());
			preparedStatement.setString(2, staffMember.getUsername());
			preparedStatement.setString(3, staffMember.getPassword());
			preparedStatement.setString(4, staffMember.getPhoneNo());
			preparedStatement.setString(5, staffMember.getAddress());
			preparedStatement.setString(6, staffMember.getDesignation());
			preparedStatement.executeUpdate();
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
	}

	
	@Override
	public StaffMember findById(int staffID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		StaffMember staffMember=null;
		
		try {
			connection = DBUtilis.getConnection();
			String query = "select * from STAFF_MEMBERS where STAFF_ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, staffID);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				staffMember=new StaffMember();
				staffMember.setStaffID(resultSet.getInt(1));
				staffMember.setName(resultSet.getString(2));
				staffMember.setUsername(resultSet.getString(3));
				staffMember.setPhoneNo(resultSet.getString(5));
				staffMember.setAddress(resultSet.getString(6));
				staffMember.setDesignation(resultSet.getString(7));
			}
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
		return staffMember;
	}

	@Override
	public StaffMember deleteById(int staffID) throws SQLException {
		StaffMember staffMemberDeleted=null;
		try {
			staffMemberDeleted = findById(staffID);
		}catch(SQLException exception) {
			throw (exception);
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getConnection();
			String query = "delete from STAFF_MEMBERS where STAFF_ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, staffID);
			preparedStatement.executeUpdate();
		} catch (SQLException exception){
			throw (exception);
		} finally {
			DBUtilis.closePreparedStatement(preparedStatement);
			DBUtilis.closeConnection(connection);
		}
		return staffMemberDeleted;
	}
}
