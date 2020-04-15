package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.forms.CreateStaffForm;
import com.capgemini.eLibrary.services.StaffService;
import com.capgemini.eLibrary.services.StaffServiceImpl;

public class CreateStaffAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(true);
		CreateStaffForm createStaffForm = (CreateStaffForm) form;
        StaffMember newStaff=new StaffMember();
        StaffService staffService = new StaffServiceImpl();
		newStaff.setName(createStaffForm.getName());
        
		newStaff.setUsername(createStaffForm.getUsername());
        try {
	        if(staffService.checkUsernameForStaff(newStaff))
	        	throw new Exception("Username already exists!!!");
        }catch(Exception exception) {
        	throw new Exception(exception.getMessage());
        }
        
        newStaff.setPhoneNo(createStaffForm.getPhoneNo());
        try {
	        if(staffService.checkPhoneNoForStaff(newStaff))
	        	throw new Exception("PhoneNo already exists!!!");
        }catch(Exception exception) {
        	throw new Exception(exception.getMessage());
        }
        
        newStaff.setPassword(createStaffForm.getPassword());
        String confirmPassword = createStaffForm.getRepassword();
        if(!newStaff.getPassword().equals(confirmPassword)) {
        	throw new Exception("Passwords do not match!!!");
        }
        
        newStaff.setAddress(createStaffForm.getAddress());
        newStaff.setDesignation(createStaffForm.getDesignation());
        
        System.out.println(newStaff);
        try {
        	newStaff = staffService.createStaff(newStaff);
        	session.setAttribute("staffMember", newStaff);
        	return mapping.findForward("registered");
        }catch(Exception exception) {
        	session.setAttribute("errorMsg", exception.getMessage());
        	return mapping.findForward("could not register");
        }
	}
}
