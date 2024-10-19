package videoHubPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminInsertServlet")
public class AdminInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean isTrue;
		
		isTrue = AdminControl.insertdata(fullname,username,email,password);
		
		if (isTrue) {
		    request.setAttribute("message", "User added successfully!");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("admindashboard.jsp");
		    dispatcher.forward(request, response);
		} else {
		    request.setAttribute("message", "Failed to add user!");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("admindashboard.jsp");
		    dispatcher.forward(request, response);
		}

		
	}

}
