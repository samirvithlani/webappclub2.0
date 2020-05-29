<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ADMIN LOGIN</h1>
<hr>
	<form:form action="adminlogin" modelAttribute="adminBean" method="post">
	
	EMAIL<form:input path="aEmail" />
	PASSWORD<form:input path="aPassword" />
	<input type="submit" value="LOGIN">
	
	</form:form>
</body>
</html>