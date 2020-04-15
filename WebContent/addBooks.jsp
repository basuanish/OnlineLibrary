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


			<%@ include file="header.jsp"%>
	<h1 align="center">
		<font color="blue">Add Book</font>
	</h1>
	
	<html:form action="addBooks" method="get">
	
	        
          <table height="230" align="center" cellspacing="10" cellpadding="8">
          <tr>
            <td>Book Name : </td><td><html:text property="bookname" /></td>
		</tr>
		<tr>
           <td>Author  : </td><td><html:text property="author" /></td>
		</tr>
		<tr>
		<td></td>
		<td colspan="2"><html:submit value="Add Book" /></td>
		</tr>
		</table>
	</html:form>
	<div style="color: red" align="center">
		<html:errors />
	</div>
	</html:html>
</body>

