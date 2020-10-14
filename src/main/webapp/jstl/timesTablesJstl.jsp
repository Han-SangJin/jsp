<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border : 1px solid block;
	}
</style>
</head>
<body>
	<table border="1">
		<c:forEach var="i" begin="1" end="9" step="1" varStatus="status">
			<tr>
				<c:forEach var="j" begin="2" end="9" step="1" varStatus="status">
					<td>${j} * ${i} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>