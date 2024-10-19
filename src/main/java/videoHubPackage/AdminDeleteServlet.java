package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminDeleteServlet")
public class AdminDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userID = request.getParameter("userID");

       
        boolean isDeleted = AdminControl.deleteUser(userID);

        
        if (isDeleted) {
            List<AdminModel> userList = AdminControl.getalldata(); 
            request.setAttribute("users", userList); 
            request.setAttribute("message", "User deleted successfully!");
        } else {
            request.setAttribute("message", "Failed to delete the user.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewUsers.jsp");
        dispatcher.forward(request, response);

    }
}
