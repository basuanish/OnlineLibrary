<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Books Successful Page</title>
</head>
<body bgcolor="silver">
	<table>
       <tr>
    <td><%=session.getAttribute("serialnumber")%></td>
    <td><%=session.getAttribute("lastName")%></td>
    <td><%=session.getAttribute("author")%></td>
    <td><%=session.getAttribute("quantity")%></td>
  </tr>
	</table>
</body>
</html>
