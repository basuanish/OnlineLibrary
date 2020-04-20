package com.capgemini.eLibrary.constants;

public class QueryConstant {
	public static final String DELETE_STAFF_BY_ID = "delete from STAFF_MEMBERS where STAFF_ID=?"; 
	public static final String FIND_STAFF_BY_ID = "select * from STAFF_MEMBERS where STAFF_ID=?";
	public static final String FIND_STAFF_BY_USERNAME = "select * from STAFF_MEMBERS where USER_NAME=?";
	public static final String FIND_STAFF_BY_PHONENO = "select * from STAFF_MEMBERS where PHONENO=?";
	public static final String ADD_NEW_STAFF = "INSERT INTO STAFF_MEMBERS (STAFF_NAME, USER_NAME, PASS, PHONENO, ADDRESS, DESIGNATION) VALUES (?,?,?,?,?,?)";
}
