package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.dto.StaffMember;
import com.capgemini.eLibrary.forms.ViewStaffForm;
import com.capgemini.eLibrary.services.StaffService;
import com.capgemini.eLibrary.services.StaffServiceImpl;

public class ViewStaffAction extends Action{
	
	static final Logger LOGGER=Logger.getLogger(ViewStaffAction.class);
	
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	HttpSession session = request.getSession(true);
        ViewStaffForm viewStaffForm = (ViewStaffForm)form;
        StaffService staffService = new StaffServiceImpl();
        
        StaffMember staffMember= new StaffMember();
        staffMember.setStaffID(viewStaffForm.getStaffID());
        try
        {
        	staffMember=staffService.fetchStaff(staffMember);
        	LOGGER.info("Staff details : "+staffMember);
        	session.setAttribute("staffMember", staffMember);
        	return mapping.findForward("view successful");
        }
        catch (Exception exception)
        {
        	request.setAttribute("errorMsg",exception.getMessage());
        	LOGGER.error(exception.getMessage());
        	return mapping.findForward("view failed");
        }
    }
}
