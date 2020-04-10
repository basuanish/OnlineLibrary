<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Admin Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="templatemo_content">
		<div id="content-box">
		<table width="500" height="300" border="0" cellspacing="20" cellpadding="0" align="center">
		<tr><th>Login Success. Welcome <bean:write name="LoginForm" property="userName"></bean:write></th></tr>
			<tr><td><a href="newstaff.jsp"> Create new staff </a></td></tr>
			<tr><td><a href="showstaff.jsp"> Show staff deatils </a></td></tr>
			<tr><td><a href="bookdetails.jsp"> Show Book deatils </a></td></tr>
			
	</table>
		</div>
	</div>


</body>
</html>