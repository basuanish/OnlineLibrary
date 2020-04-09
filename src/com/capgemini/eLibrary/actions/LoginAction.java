package com.capgemini.eLibrary.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author info@tutorials4u.net
 */
public class LoginAction extends org.apache.struts.action.Action {

   

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm loginForm = (DynaActionForm) form;
        String loginStatus = "failure";
        String userName = loginForm.get("userName").toString();
        String password = loginForm.get("password").toString();
        if(userName.equals(password) )
        {
        	loginStatus = "success";
        	System.out.println(loginStatus);
            return mapping.findForward(loginStatus);
        }
        else
        {
            return mapping.findForward(loginStatus);
        }
        
    }
}
