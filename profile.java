package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.joinDao;
import dao.profiledao;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	} 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		String username= request.getParameter("details[0]");  
		String emailid = request.getParameter("details[1]"); 
		//String coursename = request.getParameter("course");  
		String contact = request.getParameter("details[2]");
		

		profiledao pdao =new profiledao();


		String[] result = pdao.validate(emailid,username,contact);
		
		if(username != null){
			out.println("details  retrieved");
			RequestDispatcher rd=request.getRequestDispatcher("abc.jsp");  
			rd.forward(request,response);
			
		} else {
			out.println("details nt retrieved");
			RequestDispatcher rd = request.getRequestDispatcher("StudentHome.jsp");
			rd.include(request, response);
		}
		if(emailid != null){
			out.println("details  retrieved");
			RequestDispatcher rd=request.getRequestDispatcher("abc.jsp");  
			rd.forward(request,response);
			
		} else {
			out.println("details nt  retrieved");
			RequestDispatcher rd = request.getRequestDispatcher("StudentHome.jsp");
			rd.include(request, response);
		}
		if(contact != null){
			out.println("details  retrieved");
			RequestDispatcher rd=request.getRequestDispatcher("abc.jsp");  
			rd.forward(request,response);
			
		} else {
			out.println("details nt  retrieved");
			RequestDispatcher rd = request.getRequestDispatcher("StudentHome.jsp");
			rd.include(request, response);
		}
			}

}
