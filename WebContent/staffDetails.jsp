<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<title>Staff Details Page</title>
<body>
	<h1 align="center">Staff Member Details</h1>

	<table align="center" cellspacing="20">
		<tr>
			<td>ID :</td>
			<td><bean:write scope="session" name="staffMember"
					property="staffID" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><bean:write scope="session" name="staffMember"
					property="name" /></td>
		</tr>
		<tr>
			<td>User Name :</td>
			<td><bean:write scope="session" name="staffMember"
					property="username" /></td>
		</tr>

		<tr>
			<td>Phone No :</td>
			<td><bean:write scope="session" name="staffMember"
					property="phoneNo" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><bean:write scope="session" name="staffMember"
					property="address" /></td>
		</tr>
		<tr>
			<td>Designation :</td>
			<td><bean:write scope="session" name="staffMember"
					property="designation" /></td>
		</tr>
	</table>
</body>
</html>