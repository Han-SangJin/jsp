package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jobs.model.JobsVo;
import kr.or.ddit.jobs.service.JobsService;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;

@WebServlet(name = "memberList", urlPatterns = { "/memberList" })
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
		  
		// 1. 서비스 객체 생성하기
		MemberService memberService = new MemberService();
			  
		// 2. 회원 정보 조회
		List<MemberVo> memberList = memberService.selectAllMember();
		
		// 3. 결과를 화면(브라우져)에 출력하기
		request.setAttribute("msg", msg);
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberList.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
