package com.capgemini.eLibrary.dto;

public class StaffMember {
	private String staffID;
	private String name;
	private String username;
	private String password;
	private String phoneNo;
	private String address;
	private String designation;

	public StaffMember() {
	}

	public StaffMember(String name, String username, String password, String phoneNo, String address,
			String designation) {
		this();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phoneNo = phoneNo;
		this.address = address;
		this.designation = designation;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StaffMember [staffID=" + staffID + ", name=" + name + ", username=" + username + ", password="
				+ password + ", phoneNo=" + phoneNo + ", address=" + address + ", designation=" + designation + "]";
	}

}
