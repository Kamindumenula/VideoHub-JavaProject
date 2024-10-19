package videoHubPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VideoViewServlet")
public class VideoViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<VideoModel> videos = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Retrieve the logged-in user's ID from the session
            int loggedInUserID = (int) request.getSession().getAttribute("userID");

            con = DBConnection.getConnection();
            stmt = con.createStatement();
            // Update the SQL query to fetch videos only for the logged-in user
            String sql = "SELECT * FROM video WHERE userID = " + loggedInUserID;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int videoID = rs.getInt("videoID");
                String videoName = rs.getString("videoName");
                String description = rs.getString("description");
                String videoFileName = rs.getString("videoFilename");
                String thumbnailFilename = rs.getString("thumbnailFilename");
                Date uploadDate = rs.getDate("uploadDate");
                Time uploadTime = rs.getTime("uploadTime");
                int userID = rs.getInt("userID");

                VideoModel video = new VideoModel(videoID, videoName, description, uploadDate, uploadTime, videoFileName, thumbnailFilename, userID);
                videos.add(video);
            }
            request.setAttribute("videos", videos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("uploadedVideos.jsp");
            dispatcher.forward(request, response);
            
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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


