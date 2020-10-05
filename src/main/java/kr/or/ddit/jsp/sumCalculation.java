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
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final org.slf4j.Logger Logger =  LoggerFactory.getLogger(sumCalculation.class);
       
	// 입력화면 요청 처리(sumInput.jsp)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.debug("sumCalculation.doPost");
		
		int start = Integer.parseInt(request.getParameter("start"));	
		int end = Integer.parseInt(request.getParameter("end"));
		
		int sumResult = 0;
		
		for(int i =start; i<= end; i++) {
			sumResult += i;
		}
		
		request.setAttribute("sumResult", sumResult);
		Logger.debug("sumResult : {}", sumResult);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}
	
}
 