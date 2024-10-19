package videoHubPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InquiryControl {

    
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    // Insert Data Function
    public static boolean insertdata(String inquiryType, String inquiryMessage, String phoneNumber, int userID) {
        boolean isSuccess = false;

        String sql = "INSERT INTO inquiry (inquiryType, inquiryMessage, phoneNumber, userID) VALUES (?, ?, ?, ?)";

        try {
            // DB CONNECTION CALL
            con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            // Set the parameters
            pstmt.setString(1, inquiryType);
            pstmt.setString(2, inquiryMessage);
            pstmt.setString(3, phoneNumber);
            pstmt.setInt(4, userID); // Ensure this is the logged-in user's ID

            // Execute the update
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
            	isSuccess = true;
            	}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close connections
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

//GetById
public static List<InquiryModel> getById (String inquiryId){
	
	int convertedinquiryID = Integer.parseInt(inquiryId);
	
	ArrayList <InquiryModel> inquiry = new ArrayList<>();
	
	try {
		//DBConnection
		con=DBConnection.getConnection();
		stmt=con.createStatement();
		
		//Query
		String sql = "select * from inquiry where id '"+convertedinquiryID+"'";
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int inquiryID = rs.getInt(1);
			String inquiryType = rs.getString(2);
			String inquiryMessage = rs.getString(3);
			String phoneNumber = rs.getString(4);
			int userID = rs.getInt(5);
			
			InquiryModel inq = new InquiryModel(inquiryID,inquiryType,inquiryMessage,phoneNumber,userID);
			inquiry.add(inq);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return inquiry;
}
//GetAll Data
public static List<InquiryModel> getAllinquiry (){
	ArrayList <InquiryModel> inquiries = new ArrayList<>();
	try {
		//DBConnection
		con=DBConnection.getConnection();
		stmt=con.createStatement();
		
		//Query
		String sql = "select * from inquiry where userID = ?";
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int inquiryID = rs.getInt(1);
			String inquiryType = rs.getString(2);
			String inquiryMessage = rs.getString(3);
			String phoneNumber = rs.getString(4);
			int userID = rs.getInt(5);
			
			InquiryModel inq = new InquiryModel(inquiryID,inquiryType,inquiryMessage,phoneNumber,userID);
			inquiries.add(inq);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return inquiries;
	
}
//Update Data
public static boolean updatedata(String inquiryID,String inquiryType,String inquiryMessage,String phoneNumber) {
	try {
		//DBConnection
		con=DBConnection.getConnection();
		stmt=con.createStatement();
		
		//SQL Query
		String sql = "update inquiry set inquiryType= '"+inquiryType+"',inquiryMessage='"+inquiryMessage+"',phoneNumber='"+phoneNumber+"'"
				+"where inquiryID='"+inquiryID+"'";
				
		int rs = stmt.executeUpdate(sql);
		
		if(rs >0) {
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
public static List<InquiryModel> getInquiriesByUserId(int userID) {
    ArrayList<InquiryModel> inquiries = new ArrayList<>();
    try {
        // DB Connection
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        
     
        String sql = "SELECT * FROM inquiry WHERE userID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, userID);
        
        rs = pstmt.executeQuery();
        
        while (rs.next()) {
            int inquiryID = rs.getInt("inquiryID");
            String inquiryType = rs.getString("inquiryType");
            String inquiryMessage = rs.getString("inquiryMessage");
            String phoneNumber = rs.getString("phoneNumber");
            
            InquiryModel inq = new InquiryModel(inquiryID, inquiryType, inquiryMessage, phoneNumber, userID);
            inquiries.add(inq);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) con.close();
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return inquiries;
}
//Delete Data
public static boolean deletedata(String inquiryID) {
	int convinquiryID = Integer.parseInt(inquiryID);
	try {
		
		//DBConnection
		con=DBConnection.getConnection();
		stmt=con.createStatement();
		
		String sql = "delete from inquiry where inquiryID='"+convinquiryID+ "'";
		
		int rs = stmt.executeUpdate(sql);
		if(rs >0) {
			isSuccess = true;
		}
		else {
			isSuccess = false;
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();}
	return isSuccess;
	}
}
