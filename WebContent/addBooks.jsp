<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html>
<html:html>
<head>
<meta charset="ISO-8859-1">
<link href="styles.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Books Page</title>
</head>
<body>
<%@ include file="header.jsp" %>


			<%
				out.print("<h1><font color=blue>WELCOME TO ADMINISTRATION LOGIN</h1>");
			%>
	
	<html:form action="addBooks" method="get">
	
	        
          
            Book Name : <html:text property="bookname" />
		<br>
            Author  : <html:text property="author" />
		<br>

		<html:submit value="AddBooks" />
	</html:form>
	<div style="color: red">
		<html:errors />
	</div>
	</html:html>
</body>

