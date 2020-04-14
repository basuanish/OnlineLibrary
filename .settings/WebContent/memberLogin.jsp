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
<%@ include file="header.jsp" %>
<div style="color:red">
    <html:errors />
    </div>
<div id="templatemo_content">
		<div id="content-box">

			<%
				out.print("<h1><font color=blue>WELCOME TO MEMBER LOGIN</h1>");
			%>
			<html:form action="/MemberLogin">
				<table height="230" align="center" cellspacing="10" cellpadding="8">
				 <%if(request.getAttribute("exception")!=null)
			{
			out.print("<div>");
			out.print("<font color='blue'><font size='4'>"+request.getAttribute("exception")+"");
			
			out.print("</div>"); 
			}
			
			 %>
					<tr>
						<td>User Name :</td>
						<td><html:text name="MemberLoginForm" property="userName" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><html:password name="MemberLoginForm" property="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><html:submit value="Login" /> <html:reset
							value="clear"/></td>
					</tr>
				</table>
			</html:form>
		</div>
		</div>
</body>
</html:html>
