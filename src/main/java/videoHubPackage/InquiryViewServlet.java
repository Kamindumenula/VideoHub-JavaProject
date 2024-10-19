package videoHubPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InquiryViewServlet")
public class InquiryViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userID = (Integer) request.getSession().getAttribute("userID");

        if (userID != null) {
            
            List<InquiryModel> userInquiries = InquiryControl.getInquiriesByUserId(userID);
            request.setAttribute("allinquiries", userInquiries);
        } else {
            request.setAttribute("allinquiries", new ArrayList<>()); 
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("allInquiries.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


}

