<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%
    	List<MemberVo> memberList = (List<MemberVo>) request.getAttribute("memberList");
            	String msg = (String) request.getAttribute("msg");
%>    


<script>
$(document).ready(function(){
	$("#memberList tr").on("click", function(){
		// data-userid
		var userid = $(this).data("userid");
		console.log("userid : " + userid);
		
		document.location="/member/view?userid=" + userid;
	})
})
</script>


<div class="row">
	tiles : memberListContent.jsp
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
				 <tbody id="memberList">
				 
				<% 	 
					int memSize = memberList.size();
					if(memSize > 0){
						for(int i=0; i<memSize; i++){
				%>			 
					<tr data-userid="<%= memberList.get(i).getUserid() %>">
					<c:set var="userid" scope="request" value="<%= memberList.get(i).getUserid() %>"/>
						<td><%= memberList.get(i).getUserid() %></td>
						<td><%= memberList.get(i).getUsernm() %></td>
						<td><%= memberList.get(i).getAlias() %></td>
						<td><fmt:formatDate value="<%= memberList.get(i).getReg_dt() %>" pattern="yyyy-MM-dd"/></td>
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
				</tbody>
				
			</table> 
		</div>  
		<a href="${pageContext.request.contextPath}/memberRegist/view" class="btn btn-default pull-right">사용자 등록</a>

	</div>
</div>
