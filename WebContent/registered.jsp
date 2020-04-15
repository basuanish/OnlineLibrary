<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Successful Page</title>
</head>
<body>
	<h1 align="center">Registration Successful. Staff details:</h1>
	<table align="center" cellspacing="20">
		<tr>
			<td>Name :</td>
			<td><bean:write name="CreateStaffForm" property="name"></bean:write></td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td><bean:write name="CreateStaffForm" property="username"></bean:write></td>
		</tr>
		<tr>
			<td>Phone No :</td>
			<td><bean:write name="CreateStaffForm" property="phoneNo"></bean:write></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><bean:write name="CreateStaffForm" property="address"></bean:write></td>
		</tr>
		<tr>
			<td>Designation :</td>
			<td><bean:write name="CreateStaffForm" property="designation"></bean:write></td>
		</tr>
	</table>
</body>
</html>
