package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID"); 
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isTrue = UserControl.updatedata(userID, fullname, username, email, password);

        if(isTrue) {
            // Get updated user details
            List<UserModel> userdetails = UserControl.getById(userID);

            // Update session with new data
            HttpSession session = request.getSession();
            session.setAttribute("fullname", fullname);
            session.setAttribute("username", username);
            session.setAttribute("email", email);

            String alertMessage = "Data Update successful";
            response.getWriter().println("<script>alert('" + alertMessage + "'); window.location.href='userProfile.jsp'</script>");
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }
}

