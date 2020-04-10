package com.capgemini.eLibrary.dao;

import javax.sql.DataSource;

import com.capgemini.eLibrary.dto.StaffMember;

public interface StaffDAO {
	String createStaff(StaffMember staffMember, DataSource dataSource);
}
