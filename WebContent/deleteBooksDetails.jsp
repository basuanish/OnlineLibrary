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
	

		
		<tr>
		<td><h3>Bookname:</h3></td>
			<td><%=session.getAttribute("bookname")%></td>
		</tr>
		<tr>
		<td><h3>Author:</h3></td>
			<td><%=session.getAttribute("author")%></td>
		</tr>
	</table>
</body>
</html>
