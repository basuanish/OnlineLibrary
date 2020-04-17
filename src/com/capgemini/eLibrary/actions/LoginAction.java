package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.capgemini.eLibrary.DAO.LoginDAOImpl;
import com.capgemini.eLibrary.DAO.LoginDAO;
import com.capgemini.eLibrary.forms.LoginForm;

public class LoginAction extends Action {
	
	static final Logger LOGGER = Logger.getLogger(LoginAction.class);

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	HttpSession ses = request.getSession(true);
        LoginForm loginForm = (LoginForm)form;
        LoginDAO dao = new LoginDAOImpl();
        String loginStatus = "failure";
        
        try
        {
         dao.checkLogin(loginForm);
         ses.setAttribute("login", "yes");
         LOGGER.info("Login successful");
         return mapping.findForward("success");
        }
        catch (Exception e)
        {
        request.setAttribute("exception", e.getMessage());
        LOGGER.error(e.getMessage());
        ses.setAttribute("login", "no");
         return mapping.findForward("failure");
        }
    }
}
