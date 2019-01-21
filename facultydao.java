package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class facultydao {
	public String getUserName(String email) throws SQLException {
		String name = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "select Facultyname from add_faculty where email_id=?");    
			  
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
	public String validate(String email_id, String password) {
		boolean status = false;
		String coursename = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			PreparedStatement ps = con.prepareStatement("Select email_id,Password,coursename from add_faculty where email_id=? and password=?");
			ps.setString(1, email_id);
			ps.setString(2, password);
			//ps.setString(3, coursename);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
				coursename= rs.getString("coursename");
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	
		
		return coursename;
	}

	
}