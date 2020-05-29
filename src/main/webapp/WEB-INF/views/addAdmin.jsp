<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>


<body>
	<form:form action="insertAdmin" method="post"
		modelAttribute="adminBean">

	AdminName:-<form:input type="text" path="aName" />
		<form:errors path="aName" cssClass="error" />
	AdminEmail:-<form:input type="text" path="aEmail" />
		<form:errors path="aEmail" cssClass="error" />
	AdminPassword:-<form:input type="text" path="aPassword" />

		<input type="submit" value="submit">
	</form:form>
</body>
</html>