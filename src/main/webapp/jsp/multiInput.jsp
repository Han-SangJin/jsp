<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	multiInput.jsp<br>
	<form method="POST" action="${pageContext.request.contextPath }/multiCalculation" >
		start : <input type="text" name="start" value="3"/><br>
		end : <input type="text" name="end" value="5"/><br>
		<input type="submit" value="전송"/>
	</form>

</body>
</html>