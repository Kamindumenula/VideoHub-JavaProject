<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ page import="videoHubPackage.AdminControl" %>
<%@ page import="java.util.List" %>
<%@ page import="videoHubPackage.InquiryModel" %>
<%@ page import="videoHubPackage.InquiryControl" %>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <title>Admin Dashboard</title>
</head>
<body>

<div class="container mt-5">
    <h2>Admin Dashboard</h2>

    <div class="card mt-4">
        <div class="card-header">
            <h4 class="user-count">Total Users</h4>
        </div>
        <div class="card-body text-center">
            <h1 class="user-count">
                <c:out value="${AdminControl.getUserCount()}" />
            </h1>
            <p class="user-count">Total number of Users.</p>
            <a href="userInsert.jsp" class="btn btn-success">Add New User</a>
            <a href="AdminViewServlet" class="btn btn-primary">View Users</a>
        </div>
    </div>

    <!-- New Container for Inquiries -->
    <div class="card mt-4">
        <div class="card-header">
            <h4 class="inquiry-header" style="color: black">User Inquiries</h4>
        </div>
        <div class="card-body">
            <c:if test="${not empty inquiries}">
                <ul class="list-group">
                    <c:forEach items="${inquiries}" var="inquiry">
                        <li class="list-group-item">
                            <p><strong>Inquiry Type:</strong> <c:out value="${inquiry.inquiryType}" /></p>
                            <p><strong>Message:</strong> <c:out value="${inquiry.inquiryMessage}" /></p>
                            <form action="ReplyInquiryServlet" method="post">
                                <input type="hidden" name="inquiryID" value="${inquiry.inquiryID}" />
                                <textarea name="replyMessage" class="form-control" placeholder="Type your reply here..." required></textarea>
                                <button type="submit" class="btn btn-info mt-2">Reply</button>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
            <c:if test="${empty inquiries}">
                <p style="color: black">No inquiries available.</p>
            </c:if>
        </div>
    </div>

</div>

<%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
