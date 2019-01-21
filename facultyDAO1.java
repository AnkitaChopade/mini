package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class facultyDAO1 {
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

}
