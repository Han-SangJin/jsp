package kr.or.ddit.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/multiCalculation")
public class multiCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final org.slf4j.Logger Logger =  LoggerFactory.getLogger(multiCalculation.class);
       
	// 입력화면 요청 처리(sumInput.jsp)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/multiInput.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.debug("multiCalculation.doPost");
		
		int start = Integer.parseInt(request.getParameter("start"));	
		int end = Integer.parseInt(request.getParameter("end"));
		
		int multiResult = start * end;
		
		request.setAttribute("multiResult", multiResult);
		Logger.debug("multiResult : {}", multiResult);
		
		request.getRequestDispatcher("/jsp/multiResult.jsp").forward(request, response);
	}
}
 