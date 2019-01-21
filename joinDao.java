package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class joinDao {

	public boolean join(String username, String emailid, String coursename, String questions) throws SQLException {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");

			PreparedStatement ps=con.prepareStatement( "insert into java values(?,?,?,?)");    
			ps.setString(1,username);  
			ps.setString(2,emailid);  
			ps.setString(3,coursename);  
			ps.setString(4,questions);
			

			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select * from booking;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");

			PreparedStatement ps=con.prepareStatement( "insert into python values(?,?,?,?)");    
			ps.setString(1,username);  
			ps.setString(2,emailid);  
			ps.setString(3,coursename);  
			ps.setString(4,questions);
			

			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select * from booking;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");

			PreparedStatement ps=con.prepareStatement( "insert into angularjs values(?,?,?,?)");    
			ps.setString(1,username);  
			ps.setString(2,emailid);  
			ps.setString(3,coursename);  
			ps.setString(4,questions);
			

			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select * from booking;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");

			PreparedStatement ps=con.prepareStatement( "insert into cp values(?,?,?,?)");    
			ps.setString(1,username);  
			ps.setString(2,emailid);  
			ps.setString(3,coursename);  
			ps.setString(4,questions);
			

			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select * from booking;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");

			PreparedStatement ps=con.prepareStatement( "insert into html values(?,?,?,?)");    
			ps.setString(1,username);  
			ps.setString(2,emailid);  
			ps.setString(3,coursename);  
			ps.setString(4,questions);
			

			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select * from booking;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eduvista", "root", "root");

			PreparedStatement ps=con.prepareStatement( "insert into js values(?,?,?,?)");    
			ps.setString(1,username);  
			ps.setString(2,emailid);  
			ps.setString(3,coursename);  
			ps.setString(4,questions);
			

			int i=ps.executeUpdate();  
			if(i>0)  {
				//String sql = "select * from booking;";
				//Statement stat = con.createStatement();
			//	stat.executeQuery(sql);
				status = true;
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(status);
		return status;
	}

	
}
