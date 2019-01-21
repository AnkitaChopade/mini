package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginDao {

	public boolean register(String name, String email, String number, String password) throws SQLException {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			
			PreparedStatement ps=con.prepareStatement( "insert into user_details values(?,?,?,?)");    
			ps.setString(1,name);  
			ps.setString(2,email);  
			ps.setString(3,number);  
			ps.setString(4,password);  
			          
			int i=ps.executeUpdate();  
			if(i>0)  {
				String sql = "select email_id, Phone_no from user_details;";
				Statement stat = con.createStatement();
				stat.executeQuery(sql);
				status = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	//login
	
	public boolean validate(String email, String password) {
		boolean status = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			PreparedStatement ps = con.prepareStatement("Select email_id,Password from user_details where email_id=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
