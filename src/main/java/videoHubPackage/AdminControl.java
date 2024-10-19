package videoHubPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminControl {
	
	//DB Connection
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Insert Function
	public static boolean insertdata(String fullname, String username, String email, String password) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement(); 
			
			// SQL query 
			String sql = "insert into users values(0,'"+fullname+"','"+username+"','"+email+"','"+password+"')";
			int rs = stmt.executeUpdate(sql);
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess;		
	}
	
	
	//Get All 
	
public static List<AdminModel>getalldata(){
		
		
		ArrayList<AdminModel>users=new ArrayList<>();
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			String sql="select * from users ";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int userID=rs.getInt(1);
				String fullname=rs.getString(2);
				String username=rs.getString(3);
				String email=rs.getString(4);
				String password=rs.getString(5);
				
				
				AdminModel am=new AdminModel(userID,fullname,username,email,password);
				users.add(am);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	//User Count Function
	public static int getUserCount() {
	    int userCount = 0;
	    try {
	        con = DBConnection.getConnection();
	        stmt = con.createStatement();
	        
	        
	        String sql = "SELECT COUNT(*) AS total FROM users";
	        rs = stmt.executeQuery(sql);
	        
	        if (rs.next()) {
	            userCount = rs.getInt("total");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return userCount;
	}
	//Update Function
	public static boolean updatedata(String userID,String fullname, String username, String email, String password) {
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement(); 
			
			String sql = "UPDATE users SET fullname='" + fullname + "', username='" + username + "', email='" + email + "', password='" + password + "' WHERE userID='" + userID + "'";

			int rs =stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
			
			}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess;
		
	}
	//Delete Function
	    public static boolean deleteUser(String userID) {
	        boolean isSuccess = false;

	        try {
	            con = DBConnection.getConnection();
	            stmt = con.createStatement();

	      
	            String sql = "DELETE FROM users WHERE userID = '" + userID + "'";

	            // Execute the query
	            int result = stmt.executeUpdate(sql);

	            // Check if the deletion was successful
	            if (result > 0) {
	                isSuccess = true;
	            } else {
	                isSuccess = false;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the connection, if necessary
	            try {
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        return isSuccess;
	    }

}

