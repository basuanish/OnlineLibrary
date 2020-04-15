<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Login Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1 align="center">
		<font color="blue">Create Staff</font>
	</h1>
	<div id="templatemo_content">
		<div id="content-box">

			<html:form action="/CreateStaff">
				<table align="center" cellspacing="20">

					<tr>
						<td>Name :</td>
						<td><html:text name="CreateStaffForm" property="name" /></td>
					</tr>

					<tr>
						<td>User Name :</td>
						<td><html:text name="CreateStaffForm" property="username" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><html:password name="CreateStaffForm" property="password" /></td>
					</tr>
					<tr>
						<td>Re-password :</td>
						<td><html:password name="CreateStaffForm"
								property="repassword" /></td>
					</tr>
					<tr>
						<td>Phone No. :</td>
						<td><html:text name="CreateStaffForm" property="phoneNo" /></td>
					</tr>
					<tr>
						<td>Address :</td>
						<td><html:textarea name="CreateStaffForm" property="address" /></td>
					</tr>
					<tr>
						<td>Designation :</td>
						<td><html:text name="CreateStaffForm" property="designation" /></td>
					</tr>
					<tr>
						<td></td>
						<td><html:submit value="Create Staff" /></td>
					</tr>
				</table>
			</html:form>
		</div>
	</div>
	<div style="color: red" align="center">
		<html:errors />
	</div>
	<%
		if (request.getAttribute("errorMsg") != null) {
				out.print("<div>");
				out.print("<font color='red'><font size='4'>" + request.getAttribute("errorMsg"));
				out.print("</div>");
			}
	%>
</body>
</html:html>
