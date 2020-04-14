<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
</head>
<body>
	<h1>Books according to the given search criteria:</h1>
	<br>
	<table height="230" align="center" cellspacing="10" cellpadding="8">
		<tr>
			<thead>Book ID</thead>
			<thead>Book Name</thead>
			<thead>Author</thead>
		</tr>
		<logic:iterate name="books" id="singleBook">
			<tr>
				<td><bean:write name="singleBook" property="bookId" /></td>
				<td><bean:write name="singleBook" property="bookname" /></td>
				<td><bean:write name="singleBook" property="author" /></td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>