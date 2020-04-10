package com.capgemini.eLibrary.services;

import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.exceptions.BackendException;
import com.capgemini.eLibrary.exceptions.StaffCreationException;
import com.capgemini.eLibrary.exceptions.StaffDeletionException;
import com.capgemini.eLibrary.exceptions.StaffFetchingException;
import com.capgemini.eLibrary.exceptions.StaffUpdationException;

public interface StaffService {
	boolean checkUsernameForStaff(StaffMember staffMember) throws BackendException;
	boolean checkPhoneNoForStaff(StaffMember staffMember) throws BackendException;
	String createStaff(StaffMember staffMember) throws StaffCreationException;
	StaffMember fetchStaff(StaffMember staffMemberWithIdOnly) throws StaffFetchingException;
	String updateStaff(StaffMember staffMember) throws StaffUpdationException; 
	String deleteStaff(StaffMember staffMemberWithIdOnly) throws StaffDeletionException; 
}
