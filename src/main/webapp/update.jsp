<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
<meta charset="UTF-8">
<title>Update Inquiry</title>
<style>
    body {
        background-color: black;
        color: white;
        font-family: Arial, sans-serif;
    }
    table {
        margin: 0 auto;
        background-color: #333;
        border-collapse: collapse;
        width: 50%;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
    td {
        padding: 10px;
        color: white;
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        border: none;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #008CBA;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #005f6b;
    }
</style>
</head>
<body>
<%
    String inquiryID = request.getParameter("inquiryID");
    String inquiryType = request.getParameter("inquiryType");
    String inquiryMessage = request.getParameter("inquiryMessage");
    String phoneNumber = request.getParameter("phoneNumber");
%>

<form action="InquiryUpdateServlet" method="post">
    <table>
        <tr>
            <td>Inquiry ID:</td>
            <td><input type="text" id="inquiryID" name="inquiryID" value="<%=inquiryID%>" readonly></td>
        </tr>
        <tr>
            <td>Inquiry Type:</td>
            <td><input type="text" id="inquiryType" name="inquiryType" value="<%=inquiryType%>" required></td>
        </tr>
        <tr>
            <td>Inquiry Message:</td>
            <td><input id="inquiryMessage" name="inquiryMessage" value="<%=inquiryMessage%>" required></td>
        </tr>
        <tr>
            <td>Phone Number:</td>
            <td><input type="text" id="phoneNumber" name="phoneNumber" value="<%=phoneNumber%>" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
<%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>