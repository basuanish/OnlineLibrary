package com.capgemini.eLibrary.actions;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.capgemini.eLibrary.dto.StaffMember;

public class CreateStaffAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response)
			throws Exception {
		/*
		 * private String name;
	private String username;
	private String password;
	private String repassword;
	private String phoneNo;
	private String address;
	private String designation;
		 */
		DynaActionForm staffRegistrationForm = (DynaActionForm) form;
        StaffMember newStaff=new StaffMember();
		newStaff.setName(staffRegistrationForm.get("name").toString());
        String username = staffRegistrationForm.get("username").toString();
        /*if(username.equals("")) {
        	
        }*/
        System.out.println("new staff creation begins");
        newStaff.setUsername(username);
        newStaff.setPassword(staffRegistrationForm.get("password").toString());
        String confirmPassword = staffRegistrationForm.get("rePassword").toString();
        if(!newStaff.getPassword().equals(confirmPassword)) {
        	throw new Exception("Passwords do not match!!!");
        }
        newStaff.setAddress(staffRegistrationForm.get("address").toString());
        newStaff.setPhoneNo(staffRegistrationForm.get("phoneNo").toString());
        newStaff.setDesignation(staffRegistrationForm.get("designation").toString());
        System.out.println(newStaff);
        return mapping.findForward("registered");
        /*if(userName.equals(password) )
        {
            return mapping.findForward("success");
        }
        else
        {
            return mapping.findForward("failure");
        }*/
	}
}
