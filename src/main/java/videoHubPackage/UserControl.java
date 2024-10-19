package videoHubPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserControl {
	
	//Connect DB
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Insert Data Function
	public static boolean insertdata(String fullname,String username,String email,String password) {
		
		boolean isSuccess = false;
		try {
			//DB CONNECTION CALL
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			//SQL QUERY
			String sql="insert into users values(0,'"+fullname+"','"+username+"','"+email+"','"+password+"')";
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
	
			//GetById
		
		public static List<UserModel> getById(String Id){
			
			int convertedID = Integer.parseInt(Id);
			
			ArrayList <UserModel> user = new ArrayList<>();
			
			try {
				
				//DBConnection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "select * from users where id '"+convertedID+"'";
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int  userID = rs.getInt(1);
					String fullname = rs.getString(2);
					String username = rs.getString(3);
					String email = rs.getString(4);
					String password = rs.getString(5);
					
					UserModel vm = new UserModel(userID,fullname,username,email,password);
					user.add(vm);
					
				}
			}
			
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return user;
		}
		
		//GetAll Data
		public static List<UserModel> getAllUser(){
			
			ArrayList <UserModel> userList = new ArrayList<>();
try {
				
				//DBConnection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//Query
				String sql = "select * from users ";
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int  userID = rs.getInt(1);
					String fullname = rs.getString(2);
					String username = rs.getString(3);
					String email = rs.getString(4);
					String password = rs.getString(5);
					
					UserModel vm = new UserModel(userID,fullname,username,email,password);
					userList.add(vm);
					
				}
			}
			
			catch(Exception e) {
				
				e.printStackTrace();
			}
			return userList;
		}
		
		//Update data
		public static boolean updatedata(String userID,String fullname,String username,String email,String password) {
			
			try {

				//DBConnection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				//SQL Query
				String sql = "update users set fullname='"+fullname+"',username='"+username+"',email='"+email+"',password='"+password+"'"
						+"where userID='"+userID+"'";
				int rs = stmt.executeUpdate(sql);
				
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
		
		//Delete Data
		public static boolean deletedata(String userID) {
			int convID = Integer.parseInt(userID);
			try {
				//DBConnection
				//DBConnection
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				String sql = "delete from users where userID='"+convID+"'";
int rs = stmt.executeUpdate(sql);
				
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
	
	}