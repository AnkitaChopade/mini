package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ameerpetDao {
	
	public String getCentreDesc() {
		String centrename = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			PreparedStatement ps = con.prepareStatement("select centre_address from ameerpet");
			//ps.setString(1, centre_name);
			//ps.setString(2,centre_address );
			//ps.setString(2,centre_phone );
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				centrename = rs.getString(1);
			} 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(centrename);
		return centrename;
	}
	
	public boolean validate(String centre_name,String centre_address,String centre_phone) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");
			PreparedStatement ps = con.prepareStatement("select centre_name,centre_address,centre_phone from ameerpet where centre_name = ?,centre_address = ?,centre_phone = ?");
			ps.setString(1, centre_name);
			ps.setString(2,centre_address );
			ps.setString(2,centre_phone );
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
