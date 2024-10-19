package videoHubPackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class VideoControl {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt=null;
	private static ResultSet rs=null;

    // Insert Function
    public static boolean insertData(String videoName, String description, Date uploadDate, Time uploadTime, String videoFileName, String thumbnailFileName, int userID) {
        boolean isSuccess = false;
        String sql = "INSERT INTO video (videoName, description, uploadDate, uploadTime, videoFileName, thumbnailFilename, userID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, videoName);
            pstmt.setString(2, description);
            pstmt.setDate(3, uploadDate);
            pstmt.setTime(4, uploadTime);
            pstmt.setString(5, videoFileName);
            pstmt.setString(6, thumbnailFileName);
            pstmt.setInt(7, userID);

            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception for debugging
        }
        return isSuccess;
    }
//Update function
    public static boolean updatedata(int videoID, String videoName, String description) {
        boolean isSuccess = false;
        try {
            con = DBConnection.getConnection();
            String sql = "UPDATE video SET videoName = ?, description = ? WHERE videoID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, videoName);
            pstmt.setString(2, description);
            pstmt.setInt(3, videoID);

            int rs = pstmt.executeUpdate();
            isSuccess = rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

   //GetById
public static List <VideoModel> getByID(String videoId){
		
		int convertID = Integer.parseInt(videoId);
		ArrayList <VideoModel> videos = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement(); 
			
			String sql = "select * from video where videoId ='"+convertID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int videoID=rs.getInt(1);
				String videoName=rs.getString(2);
				String description=rs.getString(3);
				Date uploadDate=rs.getDate(4);
				Time uploadTime=rs.getTime(5);
				String videoFileName=rs.getString(6);
				String thumbnailFileName=rs.getString(7);
				int dbuserID= rs.getInt(8);
				
				
				VideoModel vm=new VideoModel (videoID,videoName, description, uploadDate, uploadTime, videoFileName, thumbnailFileName,dbuserID);
				videos.add(vm);}

			}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return videos;
	}
    
 //GetAllMethod
public static List<VideoModel>getallvideo(){
		
		
		ArrayList<VideoModel>videos=new ArrayList<>();
		try {
			//DB Connection 
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			
			int userID = 0;
			//Query
			String sql="select * from video WHERE userID = '"+userID+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int videoID=rs.getInt(1);
				String videoName=rs.getString(2);
				String description=rs.getString(3);
				Date uploadDate=rs.getDate(4);
				Time uploadTime=rs.getTime(5);
				String videoFileName=rs.getString(6);
				String thumbnailFileName=rs.getString(7);
				int dbuserID= rs.getInt(8);
				
				
				
				VideoModel vm=new VideoModel (videoID,videoName, description, uploadDate, uploadTime, videoFileName, thumbnailFileName,dbuserID);
				videos.add(vm);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return videos;
	}
//Delete Function
    
public static boolean deleteVideo(String videoID) {
    boolean isSuccess = false;

    try {
        // Establish a database connection
        con = DBConnection.getConnection();
        stmt = con.createStatement();

        // SQL query to delete the user
        String sql = "DELETE FROM video WHERE videoID = '" +videoID+ "'";

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
//GetAllVideos
public List<VideoModel> GetAllDBVideos() {
    List<VideoModel> videos = new ArrayList<>();
    String query = "SELECT * FROM video";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            VideoModel video = new VideoModel();
            video.setVideoID(resultSet.getInt("videoID"));
            video.setVideoName(resultSet.getString("videoName"));
            video.setDescription(resultSet.getString("description"));
            video.setVideoFileName(resultSet.getString("videoFilename"));
            video.setThumbnailFilename(resultSet.getString("thumbnailFilename"));
            video.setUploadDate(resultSet.getDate("uploadDate"));
            video.setUploadTime(resultSet.getTime("uploadTime"));
            videos.add(video);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return videos;
}
public VideoModel getByID(int videoID) {
    VideoModel video = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Get a connection to the database
        conn = DBConnection.getConnection(); // Ensure you have a method to get the database connection

        // Prepare the SQL statement to fetch video details
        String sql = "SELECT * FROM video WHERE videoID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, videoID);

        // Execute the query
        rs = pstmt.executeQuery();

        // Process the result set
        if (rs.next()) {
            video = new VideoModel();
            video.setVideoID(rs.getInt("videoID"));
            video.setVideoName(rs.getString("videoName"));
            video.setDescription(rs.getString("description"));
            video.setVideoFileName(rs.getString("videoFilename"));
            video.setThumbnailFilename(rs.getString("thumbnailFilename"));
            video.setUploadDate(rs.getDate("uploadDate")); // Make sure you handle the date format correctly
            video.setUploadTime(rs.getTime("uploadTime")); // Make sure you handle the time format correctly
        }
    } catch (Exception e) {
        e.printStackTrace(); // Handle exceptions properly in your application
    } finally {
        // Close the resources
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return video;
}


}

