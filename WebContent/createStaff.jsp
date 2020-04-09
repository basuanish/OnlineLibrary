<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Staff Page</title>
    </head>
    <body>
        <html:form action="/CreateStaff" >
            Name : <html:text name="CreateStaffForm" property="name" /> <br>
            User Name : <html:text name="CreateStaffForm" property="username" /> <br>
            Password  : <html:password name="CreateStaffForm" property="password" /> <br>
            Re-password : <html:password name="CreateStaffForm" property="rePassword" /> <br>
            Phone No. : <html:text name="CreateStaffForm" property="phoneNo" /> <br>
            Address : <html:textarea name="CreateStaffForm" property="address" /> <br>
            Designation : <html:text name="CreateStaffForm" property="designation" /> <br>
            <html:submit value="CreateStaff" />
        </html:form>
    </body>
</html>
