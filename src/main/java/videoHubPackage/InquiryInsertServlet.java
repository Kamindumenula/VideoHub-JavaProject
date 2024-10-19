package videoHubPackage;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InquiryInsertServlet")
public class InquiryInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            response.sendRedirect("login.jsp"); 
            return;
        }
        
        String inquiryType = request.getParameter("inquiryType");
        String inquiryMessage = request.getParameter("inquiryMessage");
        String phoneNumber = request.getParameter("phoneNumber");
        
        boolean isSuccess = InquiryControl.insertdata(inquiryType, inquiryMessage, phoneNumber, userID);
        
        if (isSuccess) {
            String alertMessage = "Data Insert Successful";
            response.getWriter().println("<script> alert('" + alertMessage + "'); window.location.href='InquiryViewServlet'</script>");
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
            dis2.forward(request, response);
        }
    }

}