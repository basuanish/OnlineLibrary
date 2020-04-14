package com.capgemini.eLibrary.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ViewStaffForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3853123705791979174L;
	private int staffID;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors actionErrors=new ActionErrors();
		if(staffID < 1)
			actionErrors.add("staffID",new ActionMessage("error.staffID.invalid"));
		return actionErrors;
	}
	
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
}
