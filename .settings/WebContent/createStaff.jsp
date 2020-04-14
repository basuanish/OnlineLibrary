<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Create Staff Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="color: red">
		<html:errors />
	</div>
	<div id="templatemo_content">
		<div id="content-box">

			<%
				out.print("<h1><font color=blue>MEMBER REGISTRATION</h1>");
			%>
			<html:form action="/CreateStaff">

				<table height="230" align="center" cellspacing="10" cellpadding="8">
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
						<td colspan="2"><html:submit value="CreateStaff" /></td>
				</table>
			</html:form>
		</div>
	</div>

</body>
</html:html>
