<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="styles.css" rel="stylesheet" type="text/css" />
<title>Delete Books</title>
</head>
<body>
<body>
	<%@ include file="header.jsp"%>



			<%
				out.print("<h1><font color=blue>Delete Books</h1>");
			%>

			<html:form action="/deleteBooks">
				<table width="300" height="250" cellspacing="5" cellpadding="3"
					align="center">

					
					<tr>
						<td>BOOK ID:</td>
						<td><html:text name="DeleteBooksForm" property="bookId" /></td>
					</tr>

					<tr>
						<td></td>
						<td><html:submit value="Submit" /> <INPUT TYPE=RESET
							VALUE="CLEAR"></td>
					</tr>
					<%
						if (request.getAttribute("exception") != null) {
								out.print("<div>");
								out.print("<font color='red'><font size='4'>" + request.getAttribute("exception") + "");

								out.print("</div>");
							}
					%>
				</table>
			</html:form>
			<div style="color: red">
				<html:errors />
			</div>
		
</body>
</html>