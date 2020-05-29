<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<form:form action="../updateadmin" method="post" modelAttribute="admin">


		<form:hidden path="aId" value="${admin.aId }" />
	AdminName:-<form:input type="text" path="aName" value="${admin.aName }" />
	AdminEmail:-<form:input type="text" path="aEmail"
			value="${admin.aEmail }" />
	AdminPassword:-<form:input type="text" path="aPassword"
			value="${admin.aPassword }" />

		<input type="submit" value="submit">
	</form:form>
</body>
</html>