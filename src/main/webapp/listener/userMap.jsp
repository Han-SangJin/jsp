<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		<th>userid</th>
		<th>memberVo</th>
		<br>
	</tr>
	
	<c:forEach items="${userMap }" var="user">
		<tr>
			<td>${user.key }</td>
			<td>${user.value }</td>
			<br>
		</tr>
	</c:forEach>
</body>
</html>