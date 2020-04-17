package com.capgemini.eLibrary.services;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.eLibrary.DAO.StaffDAO;
import com.capgemini.eLibrary.DAO.StaffDAOImpl;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.exceptions.BackendException;
import com.capgemini.eLibrary.exceptions.StaffCreationException;
import com.capgemini.eLibrary.exceptions.StaffDeletionException;
import com.capgemini.eLibrary.exceptions.StaffFetchingException;

public class StaffServiceImpl implements StaffService {
	
	static final Logger LOGGER=Logger.getLogger(StaffServiceImpl.class);

	@Override
	public boolean checkUsernameForStaff(StaffMember staffMember) throws BackendException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String username = staffMember.getUsername();
		boolean staffExists=true;	
		try {
			staffExists = staffDAO.existsByUsername(username);
		}catch(SQLException exception) {
			LOGGER.error("In service layer, "+exception.getMessage());
			throw new BackendException(exception.getMessage());
		}
		LOGGER.info("In service layer, staff with given username exists ? "+staffExists);
		return staffExists;
	}

	@Override
	public boolean checkPhoneNoForStaff(StaffMember staffMember) throws BackendException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String phoneNo = staffMember.getPhoneNo();
		boolean staffExists=true;
		try {
			staffExists = staffDAO.existsByUsername(phoneNo);
		}catch(SQLException exception) {
			LOGGER.error("In service layer, "+exception.getMessage());
			throw new BackendException(exception.getMessage());
		}
		LOGGER.info("staff with given phoneNo exists ? "+staffExists);
		return staffExists;
	}

	@Override
	public StaffMember createStaff(StaffMember staffMember) throws StaffCreationException {
		StaffDAO staffDAO = new StaffDAOImpl();
		try {
			staffMember=staffDAO.createStaff(staffMember);
		}catch(SQLException exception) {
			LOGGER.error("In service layer, "+exception.getMessage());
			throw new StaffCreationException(exception.getMessage());
		}
		LOGGER.info("In service layer, new staff details : "+staffMember);
		return staffMember;
	}

	@Override
	public StaffMember fetchStaff(StaffMember staffMemberWithIdOnly) throws StaffFetchingException {
		StaffDAO staffDAO = new StaffDAOImpl();
		int staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.findById(staffID);
			if(staffMember==null) {
				LOGGER.error("In service layer, the typed ID does not exist!!!");
				throw new StaffFetchingException("The typed ID does not exist!!!");
			}
		}catch(SQLException exception) {
			LOGGER.error("In service layer, "+exception.getMessage());
			throw new StaffFetchingException(exception.getMessage());
		}
		LOGGER.info("In service layer, staff details fetched : "+staffMember);
		return staffMember;
	}

	@Override
	public StaffMember deleteStaff(StaffMember staffMemberWithIdOnly) throws StaffDeletionException {
		StaffDAO staffDAO = new StaffDAOImpl();
		int staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.deleteById(staffID);
			if(staffMember==null) {
				LOGGER.error("In service layer, the typed ID does not exist!!!");
				throw new StaffDeletionException("The typed ID does not exist!!!");
			}
		}catch(SQLException exception) {
			LOGGER.error("In service layer, "+exception.getMessage());
			throw new StaffDeletionException(exception.getMessage());
		}
		LOGGER.info("In service layer, deleted staff details : "+staffMember);
		return staffMember;
	}
}
