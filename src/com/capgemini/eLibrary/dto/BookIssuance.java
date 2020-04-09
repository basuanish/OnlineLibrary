package com.capgemini.eLibrary.dto;

import java.sql.Date;

public class BookIssuance {
	private String issuanceID;
	private String bookID;
	private String usernameOfIssuer;
	private String usernameOfAcquirer;
	private Date startDate;
	private Date endDate;
	private String status;	//issued, returned
	
	public BookIssuance() {
		this.status="issued";
	}
	
	public BookIssuance(String bookID, String usernameOfIssuer, String usernameOfAcquirer,
			Date startDate, Date endDate) {
		this();
		this.bookID = bookID;
		this.usernameOfIssuer = usernameOfIssuer;
		this.usernameOfAcquirer = usernameOfAcquirer;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public BookIssuance(String bookID, String usernameOfIssuer, String usernameOfAcquirer,
			String startDate, String endDate) {
		this();
		this.bookID = bookID;
		this.usernameOfIssuer = usernameOfIssuer;
		this.usernameOfAcquirer = usernameOfAcquirer;
		this.startDate = Date.valueOf(startDate);
		this.endDate = Date.valueOf(endDate);
	}

	public String getIssuanceID() {
		return issuanceID;
	}

	public void setIssuanceID(String issuanceID) {
		this.issuanceID = issuanceID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getUsernameOfIssuer() {
		return usernameOfIssuer;
	}

	public void setUsernameOfIssuer(String usernameOfIssuer) {
		this.usernameOfIssuer = usernameOfIssuer;
	}

	public String getUsernameOfAcquirer() {
		return usernameOfAcquirer;
	}

	public void setUsernameOfAcquirer(String usernameOfAcquirer) {
		this.usernameOfAcquirer = usernameOfAcquirer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
