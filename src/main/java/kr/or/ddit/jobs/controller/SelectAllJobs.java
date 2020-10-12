package kr.or.ddit.jobs.controller;

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
import kr.or.ddit.jobs.service.JobsServiceI;

/** 
 * Servlet implementation class SelectAllJobs
 */ 
//@WebServlet(name = "selectAllJobs", urlPatterns = { "/selectAllJobs" })
@WebServlet("/selectAllJobs")
public class SelectAllJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg") == null ? "" : req.getParameter("msg");
		  
		// 1. 서비스 객체 생성하기
		JobsService jobsService = new JobsService();
			  
		// 2. 회원 정보 조회
		List<JobsVo> jobsList = jobsService.selectAllJobs();
		
		// 3. 결과를 화면(브라우져)에 출력하기
		req.setAttribute("msg", msg);
		req.setAttribute("jobsList", jobsList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/joblist.jsp");
		dispatcher.forward(req, resp);
		
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
