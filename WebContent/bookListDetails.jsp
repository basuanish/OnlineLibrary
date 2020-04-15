<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Book List Details</title>
</head>
<body>
	<h1 align="center">Books according to the given search criteria:</h1>
	<br>
	<div id="templatemo_content">
		<div id="content-box">
			<table width="300" height="250" border="1" align="center">
				<tr>
					<th>Book ID</th>
					<th>Book Name</th>
					<th>Author</th>
				</tr>
				<logic:iterate name="books" id="singleBook">
					<tr>
						<td><bean:write name="singleBook" property="bookId" /></td>
						<td><bean:write name="singleBook" property="bookname" /></td>
						<td><bean:write name="singleBook" property="author" /></td>
					</tr>
				</logic:iterate>
			</table>
		</div>
	</div>
</body>
</html>