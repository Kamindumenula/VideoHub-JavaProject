package videoHubPackage;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection {

	private static String DBurl= "jdbc:mysql://localhost:3306/videohub";
	private static String DBusername= "root";
	private static String DBpassword= "admin";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBurl, DBusername, DBpassword);
			
		}
		catch(Exception e){
			System.out.println("Database not connected!");
		}
		return con;
		
		
	}
	
}
