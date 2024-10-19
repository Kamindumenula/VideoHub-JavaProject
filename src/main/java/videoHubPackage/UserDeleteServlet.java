package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String userID = request.getParameter("userID");
		boolean isTrue=UserControl.deletedata(userID);
		
		if(isTrue) {
			List<UserModel> userList = UserControl.getAllUser();
			request.setAttribute("users", userList);
			request.setAttribute("message", "User deleted successfully!");
        } else {
        	request.setAttribute("message", "Failed to delete the user.");
        }
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	    dispatcher.forward(request, response);
	}}


	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		boolean isTrue;
		isTrue = UserControl.deletedata(userID);
		if(isTrue == true) {
			
			String alertMessage = "Data Delete Successful";
			response.getWriter().println("<script>alert('"+alertMessage+"');"+"window.location.href='errorServlet';</script>");
		}
		else {
			
			
			RequestDispatcher dispacher = request.getRequestDispatcher("wrong.jsp");
			dispacher.forward(request, response);
		}
	}*/

