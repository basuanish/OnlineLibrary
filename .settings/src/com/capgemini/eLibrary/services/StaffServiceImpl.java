package com.capgemini.eLibrary.services;

import java.sql.SQLException;

import com.capgemini.eLibrary.DAO.StaffDAO;
import com.capgemini.eLibrary.DAO.StaffDAOImpl;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.exceptions.BackendException;
import com.capgemini.eLibrary.exceptions.StaffCreationException;
import com.capgemini.eLibrary.exceptions.StaffDeletionException;
import com.capgemini.eLibrary.exceptions.StaffFetchingException;

public class StaffServiceImpl implements StaffService {

	@Override
	public boolean checkUsernameForStaff(StaffMember staffMember) throws BackendException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String username = staffMember.getUsername();
		boolean staffExists=true;
		try {
			staffExists = staffDAO.existsByUsername(username);
		}catch(SQLException exception) {
			throw new BackendException("Backend exception : "+exception.getMessage());
		}
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
			throw new BackendException("Backend exception : "+exception.getMessage());
		}
		return staffExists;
	}

	@Override
	public StaffMember createStaff(StaffMember staffMember) throws StaffCreationException {
		StaffDAO staffDAO = new StaffDAOImpl();
		try {
			staffMember=staffDAO.createStaff(staffMember);
		}catch(SQLException exception) {
			throw new StaffCreationException("StaffCreationException : "+exception.getMessage());
		}
		return staffMember;
	}

	@Override
	public StaffMember fetchStaff(StaffMember staffMemberWithIdOnly) throws StaffFetchingException {
		StaffDAO staffDAO = new StaffDAOImpl();
		int staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.findById(staffID);
			if(staffMember==null)
				throw new StaffFetchingException("StaffFetchingException : The typed ID does not exist!!!");
		}catch(SQLException exception) {
			throw new StaffFetchingException("StaffFetchingException : "+exception.getMessage());
		}
		return staffMember;
	}

	@Override
	public StaffMember deleteStaff(StaffMember staffMemberWithIdOnly) throws StaffDeletionException {
		StaffDAO staffDAO = new StaffDAOImpl();
		int staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.deleteById(staffID);
			if(staffMember==null)
				throw new StaffDeletionException("StaffDeletionException : The typed ID does not exist!!!");
		}catch(SQLException exception) {
			throw new StaffDeletionException("StaffDeletionException : "+exception.getMessage());
		}
		return staffMember;
	}
}
