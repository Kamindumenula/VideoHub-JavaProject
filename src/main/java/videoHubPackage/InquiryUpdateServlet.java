package videoHubPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InquiryUpdateServlet")
public class InquiryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inquiryID=request.getParameter("inquiryID");
		String inquiryType=request.getParameter("inquiryType");
		String inquiryMessage=request.getParameter("inquiryMessage");
		String phoneNumber=request.getParameter("phoneNumber");
		
		boolean isTrue;
		isTrue = InquiryControl.updatedata(inquiryID,inquiryType, inquiryMessage,phoneNumber);
		
		if(isTrue ==true) {
			List<InquiryModel> inquiry = InquiryControl.getById(inquiryID);
			request.setAttribute("inquiry", inquiry);
			
			String alertMessage = "Data Update Successful";
			response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='InquiryViewServlet'</script>");
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);
		}
	}

}