<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	List<MemberVo> memberList = (List<MemberVo>) request.getAttribute("memberList");
	String msg = (String) request.getAttribute("msg");
%>  
 
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<!-- 레이아웃 추가 -->
<%@ include file="/layout/commonLib.jsp" %>
</head>


<body>
<!-- 상단 네비게이션바 -->
<%@ include file="/layout/header.jsp" %>


<div class="container-fluid">
		<div class="row">


<!-- 왼쪽 사이드 바 -->			
<div class="col-sm-3 col-md-2 sidebar">
  <%@ include file="/layout/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				 <tr> 
				 	<td><p>사용자 아이디</p></td>
				 	<td><p>사용자 이름</p></td>
				 	<td><p>사용자 별명</p></td>
				 	<td><p>등록 일시</p></td>
				 </tr>
				<% 	 
					int memSize = memberList.size();
					if(memSize > 0){
						for(int i=0; i<memSize; i++){
				%>			
					<tr>
						<td><%= memberList.get(i).getUserid() %></td>
						<td><%= memberList.get(i).getUsernm() %></td>
						<td><%= memberList.get(i).getAlias() %></td>
						<td><%= memberList.get(i).getReg_dt() %></td>
					</tr>	 
				<% 			
						}
					}else{ // 회원정보가 존재하지 않을 경우...
				  %> 
					<tr>
						<td colspan="2">회원정보가 존재하지 않습니다.</td>
					</tr>
				<%	
					}
				%>
				
				
			</table>
			
			 <%
			 	if(msg.equals("성공")){
			 %>	
			 	<script>
			 		alert('정상적으로 처리되었습니다.');
			 	</script>
			 <% 	
			 	}	
			 %>
		</div>
 
		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
    

 