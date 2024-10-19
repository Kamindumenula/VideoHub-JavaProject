package videoHubPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time; // Import Time
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

@WebServlet("/VideoUploadServlet")
@MultipartConfig
public class VideoUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            response.sendRedirect("login.jsp"); 
            return;
        }

        String videoName = request.getParameter("videoName");
        String description = request.getParameter("description");

        // Get the current date and time
        java.util.Date utilDate = new java.util.Date();
        Date uploadDate = new Date(utilDate.getTime());
        Time uploadTime = new Time(utilDate.getTime());

        // Handle video file upload
        Part videoFile = request.getPart("video");
        String videoFileName = videoFile.getSubmittedFileName();
        String videoUploadPath = "C:/Projects/Video Browsing System/VideoHub/src/main/webapp/videos/" + videoFileName;

        // Handle thumbnail file upload
        Part thumbnailFile = request.getPart("thumbnail");
        String thumbnailFileName = thumbnailFile.getSubmittedFileName();
        String thumbnailUploadPath = "C:/Projects/Video Browsing System/VideoHub/src/main/webapp/thumbnails/" + thumbnailFileName;

        // Upload video file
        try (FileOutputStream videoFos = new FileOutputStream(videoUploadPath);
             InputStream videoIs = videoFile.getInputStream()) {
            byte[] videoData = new byte[videoIs.available()];
            videoIs.read(videoData);
            videoFos.write(videoData);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("message", "Video file upload failed!");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }

        // Upload thumbnail file
        try (FileOutputStream thumbnailFos = new FileOutputStream(thumbnailUploadPath);
             InputStream thumbnailIs = thumbnailFile.getInputStream()) {
            byte[] thumbnailData = new byte[thumbnailIs.available()];
            thumbnailIs.read(thumbnailData);
            thumbnailFos.write(thumbnailData);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("message", "Thumbnail upload failed!");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
            return;
        }

        // Insert data into the database
        boolean isTrue = VideoControl.insertData(videoName, description, uploadDate, uploadTime, videoFileName, thumbnailFileName, userID);

        if (isTrue) {
            String alertMessage = "Data inserted successfully";
            response.getWriter().println("<script>alert('" + alertMessage + "');window.location.href='VideoViewServlet'</script>");
        } else {
            request.setAttribute("message", "Failed to upload video!");
            request.getRequestDispatcher("wrong.jsp").forward(request, response);
        }
    }

}
