package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;

import com.capgemini.eLibrary.dto.StaffMember;

public interface StaffDAO {
	boolean existsByUsername(String username) throws SQLException;
	boolean existsByPhoneNo(String phoneNo) throws SQLException;
	String addStaffRow(StaffMember staffMember) throws SQLException;
	StaffMember findById(String staffID) throws SQLException;
	StaffMember deleteById(String staffID) throws SQLException;
}
