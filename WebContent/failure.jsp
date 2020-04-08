<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
        <title>Failure Page</title>
    </head>
    <body>
    <%@ include file="header.jsp"%>
        <div style="color:red">
            <h1>Please check your username and Password</h1>
            <jsp:forward page="admin.jsp"></jsp:forward> 
        </div>
    </body>
</html>
