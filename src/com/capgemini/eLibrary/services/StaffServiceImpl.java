package com.capgemini.eLibrary.services;

import java.sql.SQLException;

import com.capgemini.eLibrary.DAO.StaffDAO;
import com.capgemini.eLibrary.DAO.StaffDAOImpl;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.exceptions.BackendException;
import com.capgemini.eLibrary.exceptions.StaffCreationException;
import com.capgemini.eLibrary.exceptions.StaffDeletionException;
import com.capgemini.eLibrary.exceptions.StaffFetchingException;
import com.capgemini.eLibrary.exceptions.StaffUpdationException;

public class StaffServiceImpl implements StaffService {

	@Override
	public boolean checkUsernameForStaff(StaffMember staffMember) throws BackendException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String username = staffMember.getUsername();
		boolean staffExists=true;
		try {
			staffExists = staffDAO.existsByUsername(username);
		}catch(SQLException exception) {
			throw new BackendException(exception.getMessage());
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
			throw new BackendException(exception.getMessage());
		}
		return staffExists;
	}

	@Override
	public String createStaff(StaffMember staffMember) throws StaffCreationException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String result=null;
		try {
			result = staffDAO.addStaffRow(staffMember);
		}catch(SQLException exception) {
			throw new StaffCreationException(exception.getMessage());
		}
		return result;
	}

	@Override
	public StaffMember fetchStaff(StaffMember staffMemberWithIdOnly) throws StaffFetchingException {
		StaffDAO staffDAO = new StaffDAOImpl();
		String staffID = staffMemberWithIdOnly.getStaffID();
		StaffMember staffMember = null;
		try {
			staffMember = staffDAO.findById(staffID);
			if(staffMember==null)
				throw new StaffFetchingException("The typed ID does not exist!!!");
		}catch(SQLException exception) {
			throw new StaffFetchingException(exception.getMessage());
		}
		return staffMember;
	}

	@Override
	public String updateStaff(StaffMember staffMember) throws StaffUpdationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStaff(StaffMember staffMemberWithIdOnly) throws StaffDeletionException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
