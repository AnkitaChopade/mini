package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adminhomeDao {
    	public boolean validate(String email_id, String password) {
			boolean status = false;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
				PreparedStatement ps = con.prepareStatement("Select emailid,Password from admin_details where email_id=? and password=?");
				ps.setString(1, email_id);
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
