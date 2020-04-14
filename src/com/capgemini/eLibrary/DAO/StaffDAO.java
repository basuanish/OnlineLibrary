package com.capgemini.eLibrary.DAO;

import java.sql.SQLException;

import com.capgemini.eLibrary.dto.StaffMember;

public interface StaffDAO {
	boolean existsByUsername(String username) throws SQLException;
	boolean existsByPhoneNo(String phoneNo) throws SQLException;
	StaffMember createStaff(StaffMember staffMember) throws SQLException;
	StaffMember findById(int staffID) throws SQLException;
	StaffMember deleteById(int staffID) throws SQLException;
}
