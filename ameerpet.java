package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ameerpetDao;
import dao.loginDao;

/**
 * Servlet implementation class ameerpet
 */
@WebServlet("/ameerpet")
public class ameerpet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ameerpet() {
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
          
		String centre_name=request.getParameter("centre_name");  
		String centre_address=request.getParameter("centre_address");   
		String centre_phone=request.getParameter("centre_phone");
		ameerpetDao adao = new ameerpetDao();
		//String centreName = adao.getCentreDesc(centre_name);
		HttpSession session = request.getSession();
		//session.setAttribute("centre", centreName);
		//boolean result = adao.validate(centre_name,centre_address,centre_phone );		
		//if (result) {
			RequestDispatcher rd=request.getRequestDispatcher("ameerpet.jsp");  
			rd.forward(request,response);  
		/*} else {
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			rd.include(request,response);  
	
		}*/
	}
}
	
	
