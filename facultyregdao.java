package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class facultyregdao {
	public boolean register(String Faculty_id,String Facultyname, String emailid, String Phone_no,String coursename, String Password) throws SQLException {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "insert into add_faculty values(?,?,?,?,?,?)");    
			ps.setString(1,Faculty_id); 
			ps.setString(2,Facultyname);  
			ps.setString(3,emailid);  
			ps.setString(4,Phone_no);  
			ps.setString(5,coursename); 
			ps.setString(6,Password);  
			          
			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select email_id, Phone_no from user_details;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
