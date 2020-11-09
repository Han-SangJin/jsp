<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../layout/commonLib.jsp" %>


<script>
$(document).ready(function(){
	$('#profileDownBtn').on('click',function(){
		document.location="/profileDownload?userid=${memberVo.userid}"
	})
	
})  
</script>


	tiles : memberContent.jsp
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	
				<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data">
					<!-- <div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디">
						</div>
					</div> -->
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<%-- <img src="${cp}/profile/view/${memberVo.filename}"/> --%>
							
							<img src="${cp}/profileImgView?userid=${memberVo.userid}"/><br>
							<c:set var="userid" scope="request" value="${memberVo.userid}"/>
							<button id="profileDownBtn" type="button" class="btn btn-default">다운로드 :${memberVo.realFilename}</button></a>
						</div> 
					</div> 
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div id="ddd" class="col-sm-10">
							<label class="control-label ">${memberVo.userid}</label>
						</div>
					</div>
	
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.usernm}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.alias}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label">*******</label>
						</div>
					</div>

					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소1</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.addr1}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">주소2</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.addr2}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${memberVo.zipcode}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${memberVo.reg_dt}" pattern="yyyy-MM-dd"/></label>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-10">
							<a id="modiBtn" href="${cp}/memberUpdate/view?userid=${memberVo.userid}">
							<button type="button" class="btn btn-default">사용자 수정</button></a>
						</div>
					</div>
					
					  
				</form>
			</div>