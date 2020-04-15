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
	<h1 align="center">Search Books</h1>
	<div id="templatemo_content">
		<div id="content-box">

			<html:form action="/SearchBooks">
				<table height="230" align="center" cellspacing="10" cellpadding="8">
					<%
						if (request.getAttribute("errorMsg") != null) {
									out.print("<div>");
									out.print("<font color='red'><font size='4'>" + request.getAttribute("errorMsg"));
									out.print("</div>");
								}
					%>
					<tr>
						<td>Book Name :</td>
						<td><html:text name="SearchBooksForm" property="bookname" /></td>
					</tr>
					<tr>
						<td>Author :</td>
						<td><html:text name="SearchBooksForm" property="author" /></td>
					</tr>

					<tr>
						<td></td>
						<td><html:submit value="Search Book" /> <html:reset
								value="clear" /></td>
					</tr>
				</table>
			</html:form>
		</div>
	</div>
	<div style="color: red" align="center">
		<html:errors />
	</div>

</body>
</html:html>
