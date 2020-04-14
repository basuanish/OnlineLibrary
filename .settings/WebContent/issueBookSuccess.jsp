<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Issued Book</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div id="templatemo_content">
		<div id="content-box">
		<%
				out.print("<h1><font color=blue>BOOK ISSUED SUCCESSFULLY</h1>");
			%>
			
			<table width="300" height="250" border="1" align="center">
			<%
			out.print("<tr><th>ID</th><th>BOOK NAME</th><th>AUTHOR</th></tr>");
			out.print("<tr>");
			
			out.print("<td>" + request.getAttribute("bookId") + "</td>");
			out.print("<td>" + request.getAttribute("book name") + "</td>");
			out.print("<td>" + request.getAttribute("author") + "</td>");
			out.print("</tr>");
			%>
			</table>
		</div>
	</div>
</body>
</html>