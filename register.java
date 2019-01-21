package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.loginDao;
import dao.userDAO;
/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
          
String name= request.getParameter("name");  
String number = request.getParameter("number"); 
String email = request.getParameter("emailid");  
String password=request.getParameter("password");  
          
loginDao ldao = new loginDao();

try {
	boolean result = ldao.register(name, email, number, password);
	if (result) {
		userDAO udao = new userDAO();
		try {
			String uname = udao.getUserName(email);
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			RequestDispatcher rd=request.getRequestDispatcher("StudentHome.jsp");  
			rd.forward(request,response);  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rdsp = request.getRequestDispatcher("StudentHome.jsp");
		rdsp.include(request, response);
	} else {
		RequestDispatcher rdsp = request.getRequestDispatcher("index.html");
		rdsp.include(request, response);
	}

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}

