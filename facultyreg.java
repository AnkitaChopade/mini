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

import dao.facultyregdao;


/**
 * Servlet implementation class facultyreg
 */
@WebServlet("/facultyreg")
public class facultyreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public facultyreg() {
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

		PrintWriter out = response.getWriter();  

		String Faculty_id= request.getParameter("faculty id");
		String Facultyname= request.getParameter("faculty name");
		
		String emailid= request.getParameter("emailid"); 
		
		String Phone_no = request.getParameter("phoneno");  
		
		String coursename =request.getParameter("course name");
		String Password= request.getParameter("password");

		facultyregdao rdao =new facultyregdao();


		try {
			boolean result = rdao.register(Faculty_id,Facultyname,emailid,Phone_no,coursename,Password);
			if(result){
				out.println("Registered Successfull");
				RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");  
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
