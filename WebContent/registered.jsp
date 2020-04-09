<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Successful Page</title>
    </head>
    <body>
        <h1>Registration Successful. Staff details:</h1> 
        Name : <bean:write name="CreateStaffForm" property="name"></bean:write>
        User Name : <bean:write name="CreateStaffForm" property="username"></bean:write>
        Phone No : <bean:write name="CreateStaffForm" property="phoneNo"></bean:write>
        Address : <bean:write name="CreateStaffForm" property="address"></bean:write>
        Designation : <bean:write name="CreateStaffForm" property="designation"></bean:write>
    </body>
</html>
