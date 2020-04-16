<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Books Successful Page</title>
</head>
<body>
	<h1 align="center">Delete Books Successful. Book Details:</h1>
	<table align="center" cellspacing="20">

		<%
			out.print("<tr><th>BOOK NAME</th><th>AUTHOR</th></tr>");
			out.print("<tr>");

			
			out.print("<td>" + request.getAttribute("bookname") + "</td>");
			out.print("<td>" + request.getAttribute("author") + "</td>");
			out.print("</tr>");
		%>

	</table>
</body>
</html>
