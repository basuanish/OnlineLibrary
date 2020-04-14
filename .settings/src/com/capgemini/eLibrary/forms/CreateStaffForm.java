package com.capgemini.eLibrary.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CreateStaffForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994330471091949948L;
	private int staffID;
	private String name;
	private String username;
	private String password;
	private String repassword;
	private String phoneNo;
	private String address;
	private String designation;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		//[A-Z][a-z]*([ ][A-Z][a-z]*)*
		if (name == null || name.length() < 1) 
			errors.add("name", new ActionMessage("error.name.required"));
	
		//[A-Za-z][A-Za-z_0-9]+
		if (username == null || username.length() < 1) 
			errors.add("username", new ActionMessage("error.userName.required"));
		
		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));
		}
		
		if (!password.equals(repassword)) 
			errors.add("repassword", new ActionMessage("error.password.mismatch"));
		
		if (!phoneNo.matches("[0-9]{10}")) 
			errors.add("phoneNo", new ActionMessage("error.phoneNo.wrongFormat"));
		
		if (designation == null || designation.length() < 1) {
			errors.add("designation", new ActionMessage("error.designation.required"));
		}
		
		return errors;
	}

	public int getStaffID() {
		return staffID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
