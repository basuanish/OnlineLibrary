package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.constants.MessageConstant;
import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.forms.CreateStaffForm;
import com.capgemini.eLibrary.services.StaffService;
import com.capgemini.eLibrary.services.StaffServiceImpl;

public class CreateStaffAction extends Action{
	
	static final Logger LOGGER = Logger.getLogger(CreateStaffAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		CreateStaffForm createStaffForm = (CreateStaffForm) form;
        StaffMember newStaff=new StaffMember();
        StaffService staffService = new StaffServiceImpl();
		newStaff.setName(createStaffForm.getName());
        
		newStaff.setUsername(createStaffForm.getUsername());
		System.out.println(newStaff.getUsername());
        try {
	        if(staffService.checkUsernameForStaff(newStaff))
	        	throw new Exception(MessageConstant.USERNAME_EXISTS);
        }catch(Exception exception) {
        	LOGGER.error(exception.getMessage());
        	request.setAttribute(MessageConstant.ERROR_MSG_ATTRIBUTE, exception.getMessage());
        	return mapping.findForward(MessageConstant.REGISTRATION_FAILURE);
        }
        
        newStaff.setPhoneNo(createStaffForm.getPhoneNo());
        try {
	        if(staffService.checkPhoneNoForStaff(newStaff))
	        	throw new Exception(MessageConstant.PHONENO_EXISTS);
        }catch(Exception exception) {
        	LOGGER.error(exception.getMessage());
        	request.setAttribute(MessageConstant.ERROR_MSG_ATTRIBUTE, exception.getMessage());
        	return mapping.findForward(MessageConstant.REGISTRATION_FAILURE);
        }
        
        newStaff.setPassword(createStaffForm.getPassword());
        newStaff.setAddress(createStaffForm.getAddress());
        newStaff.setDesignation(createStaffForm.getDesignation());
        
        System.out.println(newStaff);
        try {
        	newStaff = staffService.createStaff(newStaff);
        	session.setAttribute(MessageConstant.STAFF_MEMBER_ATTRIBUTE, newStaff);
        	LOGGER.info(MessageConstant.IN_CREATE_STAFF_ACTION + MessageConstant.NEW_STAFF_MEMBER_CREATED);
        	return mapping.findForward(MessageConstant.REGISTRATION_SUCCESS);
        }catch(Exception exception) {
        	LOGGER.error(exception.getMessage());
        	request.setAttribute(MessageConstant.ERROR_MSG_ATTRIBUTE, exception.getMessage());
        	return mapping.findForward(MessageConstant.REGISTRATION_FAILURE);
        }
	}
}
