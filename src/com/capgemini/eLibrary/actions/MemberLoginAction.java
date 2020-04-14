package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import com.capgemini.eLibrary.DAO.LoginDAO;
import com.capgemini.eLibrary.DAO.LoginDAOImpl;
import com.capgemini.eLibrary.DAO.MemberLoginDAO;
import com.capgemini.eLibrary.DAO.MemberLoginDAOImpl;
import com.capgemini.eLibrary.forms.LoginForm;
import com.capgemini.eLibrary.forms.MemberLoginForm;

public class MemberLoginAction extends org.apache.struts.action.Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	//HttpSession ses = request.getSession(true);
        MemberLoginForm loginForm = (MemberLoginForm)form;
        MemberLoginDAO dao = new MemberLoginDAOImpl();
        String loginStatus = "failure";
        
        try
        {
         dao.checkLogin(loginForm);
         return mapping.findForward("success");
        }
        catch (Exception e)
        {
        request.setAttribute("exception", e.getMessage());
         return mapping.findForward("failure");
        }
    }
}
