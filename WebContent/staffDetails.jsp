<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

New staff member added with the given details:<br>
ID : <bean:write scope="session" name="staffMember" property="staffID" filter="false" /><br>
Name : <bean:write scope="session" name="staffMember" property="name" filter="false" /><br>
Username : <bean:write scope="session" name="staffMember" property="username" filter="false" /><br>
Phone No : <bean:write scope="session" name="staffMember" property="phoneNo" filter="false" /><br>
Address : <bean:write scope="session" name="staffMember" property="address" filter="false" /><br>
Designation : <bean:write scope="session" name="staffMember" property="designation" filter="false" /><br>
