package com.capgemini.eLibrary.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteStaffForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2593249833739222037L;
	private String staffID;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		if (staffID == null || staffID.length() < 1)
			actionErrors.add("staffID",new ActionMessage("error.staffID.required"));
		return actionErrors;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
}
