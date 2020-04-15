<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>View Staff Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h1 align="center">
		<font color="blue">View Staff</font>
	</h1>
	<div id="templatemo_content">
		<div id="content-box">
			<html:form action="/ViewStaff">
				<table height="230" align="center" cellspacing="10" cellpadding="8">
					<tr>
						<td>Staff ID :</td>
						<td><html:text name="ViewStaffForm" property="staffID" /></td>
					</tr>

					<tr>
						<td></td>
						<td><html:submit value="View Staff Details" /> <html:reset
								value="clear" /></td>
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
				out.print("<div align=\"center\">");
				out.print("<font color='red'><font size='4'>" + request.getAttribute("errorMsg"));
				out.print("</div>");
			}
	%>
</body>
</html:html>
