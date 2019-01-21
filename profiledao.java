package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class profiledao {
	public String getUserName(String email) throws SQLException {
		String name = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "select Username from user_details where email_id=?");    
			  
			ps.setString(1,email);  
			ResultSet rs = ps.executeQuery();  
			if(rs.next())  {
				name = rs.getString(1);
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	public String[] validate(String email_id,String Username,String Phone_no) {
		//boolean status = false;
		//String coursename = null;
		String[] details = null;
		
		String email = null;
		String uname = null;
		String contact = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			PreparedStatement ps = con.prepareStatement("select email_id,  Username, Phone_no from add_faculty where email_id=?,Username=?, Phone_no=?");
		    
			ps.setString(1, email_id);
			ps.setString(2, Username);
			ps.setString(3, Phone_no);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("In while loop!");
				details[0] = rs.getString(1);
				System.out.println(details[0]);
				details[1] = rs.getString(2);
				System.out.println(details[1]);
				details[2] = rs.getString(3);
				System.out.println(details[2]);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	
		
		return details;
	}

	
}