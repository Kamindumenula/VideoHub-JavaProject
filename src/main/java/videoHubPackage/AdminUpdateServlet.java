package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID=request.getParameter("userID");
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean isTrue;
		isTrue = AdminControl.updatedata(userID, fullname, username, email, password);
		

		if (isTrue) {
		    List<AdminModel> userList = AdminControl.getalldata(); 
		    request.setAttribute("users", userList); 
		    request.setAttribute("message", "User updated successfully!");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("viewUsers.jsp");
		    dispatcher.forward(request, response);
		} else {
		    request.setAttribute("message", "Failed to update user!");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("viewUsers.jsp");
		    dispatcher.forward(request, response);
		}

		
	}

}
