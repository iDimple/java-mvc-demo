<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>用户名</th>
			<th>口令</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.userName }</td>
				<td>${user.password }</td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>