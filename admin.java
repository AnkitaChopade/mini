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
import javax.servlet.http.HttpSession;

import dao.adminDAO;
import dao.adminhomeDao;

import dao.userDAO;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
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
		doGet(request, response);
	
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
          
		String emailid=request.getParameter("email");  
		String password=request.getParameter("password");    
		adminhomeDao adao = new adminhomeDao();
		
		boolean result = adao.validate(emailid, password);
		
		if (result) {
			adminDAO addao = new adminDAO();
			try {
				String aname = addao.getUserName(emailid);
				HttpSession session = request.getSession();
				session.setAttribute("aname", aname);
				RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");  
				rd.forward(request,response);  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  
		}  
		
		 else {
			out.print("Sorry username or password error");  
			RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			rd.include(request,response);  
		}  

	
	}

}
