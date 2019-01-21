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

import dao.facultyDAO1;
import dao.facultydao;
import dao.userDAO;

/**
 * Servlet implementation class faculty
 */
@WebServlet("/faculty")
public class faculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public faculty() {
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
          
		
          
		String email_id=request.getParameter("email");  
		String password=request.getParameter("password");    
		facultydao fdao = new facultydao();
		
		
		
		String result = fdao.validate(email_id,password);
		if (result != null) {
			facultyDAO1 fadao = new facultyDAO1();;
			try {
				String fname = fadao.getUserName(email_id);
				HttpSession session = request.getSession();
				session.setAttribute("fname", fname);
				session.setAttribute("course", result);
				System.out.println(result);
				RequestDispatcher rd=request.getRequestDispatcher("FacultyHome.jsp");  
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
