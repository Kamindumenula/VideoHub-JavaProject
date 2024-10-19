package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VideoDeleteServlet")
public class VideoDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String videoID = request.getParameter("videoID");

       
        boolean isDeleted = VideoControl.deleteVideo(videoID);

        
        if (isDeleted) {
            List<VideoModel> videoList = VideoControl.getallvideo();// Fetch the updated user list
            request.setAttribute("videos", videoList); // Set the list in request scope
            request.setAttribute("message", "Video deleted successfully!");
        } else {
            request.setAttribute("message", "Failed to delete the video.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("VideoViewServlet");
        dispatcher.forward(request, response);

    }
}
