<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%-- 
		jsp 스크립트 : 서버에서 실행됨
		<% %> , <%= %>
	 --%>
	<% String str = "message"; %>
	<% String str2 = ""; %>
	<% String str3 = "hello"; %>
<script>

	/*서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우(x)
	  서버 사이트 스크립트가 먼저 실행되므로 논리적으로 말이 안된다.*/
	<%= str %> = 'test';
	//<%= str2 %> = 'test';
<%-- 	<%= str2 %> = 'test'; --%>

	/* 클라이언트 사이드 변수에 서버 사이드 변수 값을대입 
	서버사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다.*/
	var msg = '<%= str3 %>';		

	
	

	jsp 프로젝트(contextPath ROOT(/))의 webapp/jsp/test.jsp를 접근하기 위해서는
			http://localhost/jsp.test.jsp로 요청.
			
			
			jsp2 프로젝트(contextPath jsp)의 webapp/jsp/test.jsp를 접근하기 위해서는
			http://localhost/jsp.test.jsp로 요청.)
			
			즉 두개의 리소스가 동일한 url을 갖는다
			이럴때 contextPath를 우선시하여 처리. (이게 중요한 것은 아님)
			
			url만 보고서 경로에 나오는 path가 contextPath 인지, webapp 폴더 하위의 디렉토리 인지는 알 수가 없다.
			


			
</script>	
</head>
<body>

</body>
</html>