<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<% for(int i=2; i<=9; i++) { %>
		<tr>
			<% for(int j=1; j<=9; j++) { %>
			<td width='90' height='60'>
	    		<%= i %> * <%= j %> = <%= i*j %> 
			</td>
			<% } %>	
		</tr> 
		<% } %>	
	</table>
</body>
</html>