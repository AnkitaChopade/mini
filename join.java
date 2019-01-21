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

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public join() {
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

		String username= request.getParameter("username");  
		String emailid= request.getParameter("email"); 
		String coursename = request.getParameter("course");  
		
		String questions=request.getParameter("questions");

		joinDao jdao =new joinDao();


		try {
			boolean result = jdao.join(username,emailid,coursename,questions);
			if(result){
				out.println("Registered Successfull");
				RequestDispatcher rd=request.getRequestDispatcher("StudentHome.jsp");  
				rd.forward(request,response);
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
