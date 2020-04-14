<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Books Page</title>
</head>
<body>
	<html:html>
	<div style="color: red">
		<html:errors />
	</div>
	<html:form action="addBooks" method="get">
          
            Book Name : <html:text property="bookname" />
		<br>
            Author  : <html:text property="author" />
		<br>

		<html:submit value="AddBooks" />
	</html:form>
	</html:html>
</body>
</html>
