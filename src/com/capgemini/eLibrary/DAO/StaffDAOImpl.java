package com.capgemini.eLibrary.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.eLibrary.constants.MessageConstant;
import com.capgemini.eLibrary.constants.QueryConstant;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.utils.DBUtilis;

public class StaffDAOImpl implements StaffDAO {

	static final Logger LOGGER = Logger.getLogger(StaffDAOImpl.class);

	@Override
	public boolean existsByUsername(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean staffExists = false;
		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = QueryConstant.FIND_STAFF_BY_USERNAME;
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				staffExists = true;
			}
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
			throw exception;
		} finally {
			preparedStatement.close();
			connection.close();
		}
		LOGGER.info(MessageConstant.IN_DAO_LAYER + MessageConstant.EXISTS_BY_USERNAME_OR_NOT + staffExists);
		return staffExists;
	}

	@Override
	public boolean existsByPhoneNo(String phoneNo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean staffExists = false;

		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = QueryConstant.FIND_STAFF_BY_PHONENO;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phoneNo);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				staffExists = true;
			}
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
			throw exception;
		} finally {
			preparedStatement.close();
			connection.close();
		}
		LOGGER.info(MessageConstant.IN_DAO_LAYER + MessageConstant.EXISTS_BY_PHONENO_OR_NOT + staffExists);
		return staffExists;
	}

	@Override
	public StaffMember createStaff(StaffMember staffMember) throws SQLException {
		try {
			addStaffRow(staffMember);
		} catch (SQLException exception) {
			throw (exception);
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = QueryConstant.FIND_STAFF_BY_USERNAME;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, staffMember.getUsername());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				staffMember.setStaffID(rs.getInt(1));
			}
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
			throw exception;
		} finally {
			preparedStatement.close();
			connection.close();
		}
		LOGGER.info(MessageConstant.IN_DAO_LAYER + MessageConstant.NEW_STAFF_DETAILS + staffMember);
		return staffMember;
	}

	public void addStaffRow(StaffMember staffMember) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getInstance().getConnection();
			connection.setAutoCommit(false);
			String query = QueryConstant.ADD_NEW_STAFF;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, staffMember.getName());
			preparedStatement.setString(2, staffMember.getUsername());
			preparedStatement.setString(3, staffMember.getPassword());
			preparedStatement.setString(4, staffMember.getPhoneNo());
			preparedStatement.setString(5, staffMember.getAddress());
			preparedStatement.setString(6, staffMember.getDesignation());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException exception) {
			try {
				if (connection != null) {
					connection.rollback();
				}
				LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
				throw exception;
			} catch (SQLException exception2) {
				LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
				throw exception;
			}
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}

	@Override
	public StaffMember findById(int staffID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		StaffMember staffMember = null;

		try {
			connection = DBUtilis.getInstance().getConnection();
			String query = QueryConstant.FIND_STAFF_BY_ID;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, staffID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				staffMember = new StaffMember();
				staffMember.setStaffID(resultSet.getInt(1));
				staffMember.setName(resultSet.getString(2));
				staffMember.setUsername(resultSet.getString(3));
				staffMember.setPhoneNo(resultSet.getString(5));
				staffMember.setAddress(resultSet.getString(6));
				staffMember.setDesignation(resultSet.getString(7));
			}
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
			throw exception;
		} finally {
			preparedStatement.close();
			connection.close();
		}
		LOGGER.info(MessageConstant.IN_DAO_LAYER + MessageConstant.FOUND_STAFF_DETAILS + staffMember);
		return staffMember;
	}

	@Override
	public StaffMember deleteById(int staffID) throws SQLException {
		StaffMember staffMemberDeleted = null;
		try {
			staffMemberDeleted = findById(staffID);
		} catch (SQLException exception) {
			throw (exception);
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtilis.getInstance().getConnection();
			connection.setAutoCommit(false);
			String query = QueryConstant.DELETE_STAFF_BY_ID;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, staffID);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException exception) {
			try {
				if (connection != null) {
					connection.rollback();
				}
				LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
				throw exception;
			} catch (SQLException exception2) {
				LOGGER.error(MessageConstant.IN_DAO_LAYER + exception.getMessage());
				throw exception;
			}
		} finally {
			preparedStatement.close();
			connection.close();
		}
		LOGGER.info(MessageConstant.IN_DAO_LAYER + MessageConstant.DELETED_STAFF_DETAILS + staffMemberDeleted);
		return staffMemberDeleted;
	}
}
