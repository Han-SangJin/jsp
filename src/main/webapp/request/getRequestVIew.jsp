<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	label{
		display : inline-block;
		width : 80px;
	}
</style>
</head>
<body>

	 <%-- 
		 파라미터 : client 서버로 요청을 보낼때 추가적으로 보낸 값
				ex : 로그인 요청시 : 사용자 id, 비밀번호
				
		 파라미터는 내부적으로 Map<String, Stringp[]> 객체로 관리를 한다.
		 					파라미터이름, 파라미터 값들
		 					==> 동일한 이름의 파라미터를 여러개 보낼 수 있다.
		 
		 request 객체에 있는 파라미터 관련 메소드 4가지
		 
		 - String = getParameter(String param) : param에 해당하는 파라미터 값을 조회한다. 파라미터 맵에서 첫번째 값을 반환 
		 - String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다.	
		 - Map<String, String[]> getParameterMap() : request 객체에 생성된 파라미터 맵을 반환
		 - Enumeration<String> getParameterNames() : request 객체에 담긴 모든 파라미터 이름을 반환
	 --%>
	 
	 
	 <%-- 
	 	 한글 파라미터 설정
		 get : server.xml <Connector URIEncoding="utf-8">
		 post : request.setCharacterEncoding("utf-8");
		 		request.getParamerter() 메소드를 호출하기 전에 설정을 해줘야 한다. 
	  --%>
	 
	 
	 <%-- 
	  	 action : 요청을 보낼 경로
	 	 method : 요청 방식 (form에서는 GET, POST두가지만 가능하며 DEFAULT는 GET)
	  --%>
	 
	
	  
	<!-- GET POST 두가지를 선택할 수 있는 라디오 버튼을 만들어서 FORM 전송시 사용자가 GET, POST 방식을 지정할 수 있도록  -->
	
	<input type="radio" value="get" name="do" id="get" class="ra">GET
	<input type="radio" value="post" name="do" id="post" class="ra">POST<br><br>
	
	
<%-- 	<%
			String get = request.getParameter("get");
			String post = request.getParameter("post");
		%>
		 --%>

	
	
	
	<form action="<%=request.getContextPath() %>/request/getRequestResponse.jsp">
		<label>user id :</label> <input type="text" name="userId" value="브라운"><br>
		<label>user id :</label> <input type="text" name="userId" value="셀리"><br>
		<label>password :</label> <input type="password" name="pass" value="pass1234"><br>
		<input type="submit" value="전송">
	</form>
	  
	  
	
<script>
	$(function(){
		get = $('#get').val();
		post = $('#post').val();
		var target = document.getElementsByTagName('form')[0];
		
		$('.ra').click(function(){
			
			id = $(this).attr('id');
			
			if(id=='get'){
				 target.setAttribute('method','get');
				$('#result').html(get);
			}else if(id=='post'){
				 target.setAttribute('method','post');
				$('#result').html(post);
			}
		}) 
	})
</script>	
	
	<div id="result">dd</div>
</body>
</html> 