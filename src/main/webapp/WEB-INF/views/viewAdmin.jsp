<%@page import="org.springframework.ui.Model"%>
<%@page import="com.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		ADMINS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">INDEX</a> <a
			href="adminlogout">LOGOUT</a>
	</h1>
	${loginAdmin.aName }
	<hr>
	<br>
	<table border="3">
		<tr>
			<th>adminName</th>
			<th>adminEmail</th>
			<th>adminpassword</th>
			<th>ACTION</th>
		</tr>

		<c:forEach items="${admins }" var="adminBean">
			<tr>

				<td><a href="getadmindetail/${adminBean.aId }" target="_blank">${adminBean.aName }</a></td>


				<td>${adminBean.aEmail }</td>


				<td>${adminBean.aPassword }</td>

				<td><a href="deleteadmin/${adminBean.aId}">DELETE</a></td>
				<td><a href="editadmin/${adminBean.aId}">UPDATE</a></td>
				<%-- <td><a href="deleteadmin?aid=${adminBean.aId}">DELETE</a></td> --%>

			</tr>
		</c:forEach>

	</table>
</body>
</html>