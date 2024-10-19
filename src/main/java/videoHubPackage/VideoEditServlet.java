package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VideoEditServlet")
public class VideoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int videoID = Integer.parseInt(request.getParameter("videoID"));
	    String videoName = request.getParameter("videoName");
	    String description = request.getParameter("description");
	    
	    boolean isUpdated = VideoControl.updatedata(videoID, videoName, description);
	    
	    if (isUpdated) {
	        response.sendRedirect("VideoViewServlet");
	    } else {
	        response.getWriter().write("Failed to update video details.");
	    }
	}


}
