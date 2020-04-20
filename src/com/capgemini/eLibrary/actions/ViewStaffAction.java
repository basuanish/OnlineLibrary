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
import com.capgemini.eLibrary.forms.ViewStaffForm;
import com.capgemini.eLibrary.services.StaffService;
import com.capgemini.eLibrary.services.StaffServiceImpl;

public class ViewStaffAction extends Action {

	static final Logger LOGGER = Logger.getLogger(ViewStaffAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		ViewStaffForm viewStaffForm = (ViewStaffForm) form;
		StaffService staffService = new StaffServiceImpl();

		StaffMember staffMember = new StaffMember();
		staffMember.setStaffID(viewStaffForm.getStaffID());
		try {
			staffMember = staffService.fetchStaff(staffMember);
			LOGGER.info(MessageConstant.IN_VIEW_STAFF_ACTION + MessageConstant.FETCHED_STAFF_DETAILS + staffMember);
			session.setAttribute(MessageConstant.STAFF_MEMBER_ATTRIBUTE, staffMember);
			return mapping.findForward(MessageConstant.VIEW_SUCCESSFUL);
		} catch (Exception exception) {
			request.setAttribute(MessageConstant.ERROR_MSG_ATTRIBUTE, exception.getMessage());
			LOGGER.error(exception.getMessage());
			return mapping.findForward(MessageConstant.VIEW_FAILED);
		}
	}
}
