<%@page import="kr.or.ddit.jobs.model.JobsVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<JobsVo> jobList = (List<JobsVo>) request.getAttribute("jobList");
	String msg = (String) request.getAttribute("msg");

%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원목록</title>
</head>
<body>
<table border="1">
 <tr>
 	<td colspan="2"></td>
 </tr>
 <tr> 
 	<td>ID</td>
 	<td>title</td>
 </tr>
<% 	 
	int jobSize = jobList.size();
	if(jobSize > 0){
		for(int i=0; i<jobSize; i++){
%>			
	<tr>
		<td><%= jobList.get(i).getJob_id() %></td>
		<td><%= jobList.get(i).getJob_title() %></td>
	</tr>	 
<% 			
		}
	}else{ // 회원정보가 존재하지 않을 경우...
  %>
	<tr>
		<td colspan="4">회원정보가 존재하지 않습니다.</td>
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
</body>
</html>