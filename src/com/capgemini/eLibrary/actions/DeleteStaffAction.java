package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.forms.DeleteStaffForm;
import com.capgemini.eLibrary.services.StaffService;
import com.capgemini.eLibrary.services.StaffServiceImpl;

public class DeleteStaffAction extends Action {
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		HttpSession session = request.getSession(true);
        DeleteStaffForm deleteStaffForm = (DeleteStaffForm)form;
        StaffService staffService = new StaffServiceImpl();
        
        StaffMember staffMember= new StaffMember();
        try
        {
        	staffMember.setStaffID(deleteStaffForm.getStaffID());
        	staffMember=staffService.deleteStaff(staffMember);
        	session.setAttribute("staffMember", staffMember);
        	return mapping.findForward("deletion successful");
        }
        catch (Exception exception)
        {
        	request.setAttribute("errorMsg", exception.getMessage());
        	return mapping.findForward("deletion failed");
        }
    }
}
