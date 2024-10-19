package videoHubPackage;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement userStmt = null;
        PreparedStatement adminStmt = null;
        ResultSet userRs = null;
        ResultSet adminRs = null;
        HttpSession session = request.getSession();

        try {
            // Database connection
            conn = DBConnection.getConnection();

            // Query for user login
            String userQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
            userStmt = conn.prepareStatement(userQuery);
            userStmt.setString(1, username);
            userStmt.setString(2, password);
            userRs = userStmt.executeQuery();

            // Query for admin login
            String adminQuery = "SELECT * FROM admin WHERE adminUsername = ? AND adminPassword = ?";
            adminStmt = conn.prepareStatement(adminQuery);
            adminStmt.setString(1, username);
            adminStmt.setString(2, password);
            adminRs = adminStmt.executeQuery();

            if (userRs.next()) {
                // User login successful
                session.setAttribute("userID", userRs.getInt("userID")); // Set userID in session
                session.setAttribute("username", userRs.getString("username"));
                session.setAttribute("fullname", userRs.getString("fullname"));
                session.setAttribute("email", userRs.getString("email"));
                session.setAttribute("role", "user");
                response.sendRedirect("userProfile.jsp");
            } else if (adminRs.next()) {
                // Admin login successful
                session.setAttribute("adminUsername", adminRs.getString("adminUsername"));
                session.setAttribute("role", "admin");
                response.sendRedirect("admindashboard.jsp");
            } else {
                // Login fails
                response.sendRedirect("login.jsp?error=invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (userRs != null) userRs.close();
                if (adminRs != null) adminRs.close();
                if (userStmt != null) userStmt.close();
                if (adminStmt != null) adminStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

 }

