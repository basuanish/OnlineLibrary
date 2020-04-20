package com.capgemini.eLibrary.services;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.eLibrary.DAO.StaffDAO;
import com.capgemini.eLibrary.DAO.StaffDAOImpl;
import com.capgemini.eLibrary.constants.MessageConstant;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.exceptions.BackendException;
import com.capgemini.eLibrary.exceptions.StaffCreationException;
import com.capgemini.eLibrary.exceptions.StaffDeletionException;
import com.capgemini.eLibrary.exceptions.StaffFetchingException;

public class StaffServiceImpl implements StaffService {

	static final Logger LOGGER = Logger.getLogger(StaffServiceImpl.class);

	@Override
	public boolean checkUsernameForStaff(StaffMember staffMember) throws BackendException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String username = staffMember.getUsername();
		boolean staffExists = true;
		try {
			staffExists = staffDAO.existsByUsername(username);
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_SERVICE_LAYER + exception.getMessage());
			throw new BackendException(exception.getMessage());
		}
		LOGGER.info(MessageConstant.IN_SERVICE_LAYER + MessageConstant.EXISTS_BY_USERNAME_OR_NOT + staffExists);
		return staffExists;
	}

	@Override
	public boolean checkPhoneNoForStaff(StaffMember staffMember) throws BackendException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String phoneNo = staffMember.getPhoneNo();
		boolean staffExists = true;
		try {
			staffExists = staffDAO.existsByUsername(phoneNo);
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_SERVICE_LAYER + exception.getMessage());
			throw new BackendException(exception.getMessage());
		}
		LOGGER.info(MessageConstant.IN_SERVICE_LAYER + MessageConstant.EXISTS_BY_PHONENO_OR_NOT + staffExists);
		return staffExists;
	}

	@Override
	public StaffMember createStaff(StaffMember staffMember) throws StaffCreationException {
		StaffDAO staffDAO = new StaffDAOImpl();
		try {
			staffMember = staffDAO.createStaff(staffMember);
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_SERVICE_LAYER + exception.getMessage());
			throw new StaffCreationException(exception.getMessage());
		}
		LOGGER.info(MessageConstant.IN_SERVICE_LAYER + MessageConstant.NEW_STAFF_DETAILS + staffMember);
		return staffMember;
	}

	@Override
	public StaffMember fetchStaff(StaffMember staffMemberWithIdOnly) throws StaffFetchingException {
		StaffDAO staffDAO = new StaffDAOImpl();
		int staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.findById(staffID);
			if (staffMember == null) {
				LOGGER.error(MessageConstant.IN_SERVICE_LAYER + MessageConstant.GIVEN_ID_DOES_NOT_EXIST);
				throw new StaffFetchingException(MessageConstant.GIVEN_ID_DOES_NOT_EXIST);
			}
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_SERVICE_LAYER + exception.getMessage());
			throw new StaffFetchingException(exception.getMessage());
		}
		LOGGER.info(MessageConstant.IN_SERVICE_LAYER + MessageConstant.FETCHED_STAFF_DETAILS + staffMember);
		return staffMember;
	}

	@Override
	public StaffMember deleteStaff(StaffMember staffMemberWithIdOnly) throws StaffDeletionException {
		StaffDAO staffDAO = new StaffDAOImpl();
		int staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.deleteById(staffID);
			if (staffMember == null) {
				LOGGER.error(MessageConstant.IN_SERVICE_LAYER + MessageConstant.GIVEN_ID_DOES_NOT_EXIST);
				throw new StaffDeletionException(MessageConstant.GIVEN_ID_DOES_NOT_EXIST);
			}
		} catch (SQLException exception) {
			LOGGER.error(MessageConstant.IN_SERVICE_LAYER + exception.getMessage());
			throw new StaffDeletionException(exception.getMessage());
		}
		LOGGER.info(MessageConstant.IN_SERVICE_LAYER + MessageConstant.DELETED_STAFF_DETAILS + staffMember);
		return staffMember;
	}
}
