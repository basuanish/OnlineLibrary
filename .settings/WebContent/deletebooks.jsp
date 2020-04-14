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

<div style="color:red">
    <html:errors />
    </div>
<div id="templatemo_content">
		<div id="content-box">

			<%
				out.print("<h1><font color=blue>DELETE BOOKS</h1>");
			%>
			<html:form action="/deleteBooks">
				<table height="230" align="center" cellspacing="10" cellpadding="8">
					<tr>
						<td>Staff ID :</td>
						<td><html:text name="DeleteBooksForm" property="bookId" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><html:submit value="deleteBooks" /> <html:reset
							value="clear"/></td>
					</tr>
				</table>
			</html:form>
		</div>
		</div>
</body>
</html:html>
