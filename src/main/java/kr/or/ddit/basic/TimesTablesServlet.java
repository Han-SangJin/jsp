package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimesTablesServlet
 */
@WebServlet("/TimesTablesServlet")
public class TimesTablesServlet extends HttpServlet {
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		 
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head></head>");
		writer.println("<body>");
		writer.println("<table border='1'>");
					  for(int i=2; i<=9; i++) { 
	    writer.println(			"<tr>");
	    					for(int j=1; j<=9; j++) {
	    writer.println(				"<td width='90' height='60'>" + i + " * " + j + " = " + i*j);		
	    writer.println(				"</td>");
	    					}
	    writer.println(			"<br>");
	    writer.println(			"</tr>");
	    					 
					  } 
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html");
		
		writer.flush();
		writer.close(); 
		
	} 

}
 