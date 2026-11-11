package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/student_management";
		String username = "root";
		String password = "YOUR_MYSQL_PASSWORD";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected successfully");
			return con;
		}
		catch(SQLException e) {
			System.out.println("Database connection failed!");
			e.printStackTrace();
			return null;
		}
	}

}
