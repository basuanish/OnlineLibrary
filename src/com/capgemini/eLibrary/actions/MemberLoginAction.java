package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import com.capgemini.eLibrary.DAO.MemberLoginDAO;
import com.capgemini.eLibrary.DAO.MemberLoginDAOImpl;
import com.capgemini.eLibrary.forms.MemberLoginForm;

public class MemberLoginAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	HttpSession ses = request.getSession(true);
        MemberLoginForm loginForm = (MemberLoginForm)form;
        MemberLoginDAO dao = new MemberLoginDAOImpl();
        
        try
        {
         dao.checkLogin(loginForm);
         ses.setAttribute("login", true);
         return mapping.findForward("success");
        }
        catch (Exception e)
        {
        request.setAttribute("exception", e.getMessage());
        ses.setAttribute("login", false);
         return mapping.findForward("failure");
        }
    }
}
