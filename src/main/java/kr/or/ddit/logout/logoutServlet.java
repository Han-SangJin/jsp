package kr.or.ddit.logout;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVo;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo membervo = (MemberVo)request.getSession().getAttribute("S_MEMBER");
		
		System.out.println(membervo.getUserid());
		
		request.getSession().invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
