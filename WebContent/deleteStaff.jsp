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
		<font color="blue">Delete Staff</font>
	</h1>
	<div id="templatemo_content">
		<div id="content-box">
			<html:form action="/DeleteStaff">
				<table height="230" align="center" cellspacing="10" cellpadding="8">
					<tr>
						<td>Staff ID :</td>
						<td><html:text name="DeleteStaffForm" property="staffID" /></td>
					</tr>

					<tr>
						<td></td>
						<td><html:submit value="Delete Staff" /> <html:reset
								value="clear" /></td>
					</tr>
				</table>
			</html:form>
			<div style="color: red">
				<html:errors />
			</div>
			<%
				if (request.getAttribute("errorMsg") != null) {
						out.print("<div>");
						out.print("<font color='red'><font size='4'>" + request.getAttribute("errorMsg"));
						out.print("</div>");
					}
			%>
		</div>
	</div>
</body>
</html:html>
