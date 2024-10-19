<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inquiries</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
<style>
    body {
        background-color: black;
        color: white;
        font-family: Arial, sans-serif;
    }
    h2 {
        text-align: center;
        color: #f2f2f2;
    }
    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #333;
        color: white;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
    th, td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #555;
        color: white;
    }
    tr:hover {
        background-color: #444;
    }
    button {
        background-color: #008CBA;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        transition: 0.3s;
    }
    button:hover {
        background-color: #005f6b;
    }
    form {
        display: inline;
    }
</style>
<script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this inquiry?");
    }
</script>
</head>
<body>
<h2>Inquiries</h2>
    
    <table>
        <tr>
            <th>inquiryID</th>
            <th>inquiryType</th>
            <th>inquiryMessage</th>
            <th>phoneNumber</th>
            <th>Action</th>
        </tr>
        <c:forEach var="inquiry" items="${allinquiries }">
        <tr>
        
        <td>${inquiry.inquiryID}</td>
        <td>${inquiry.inquiryType}</td>
        <td>${inquiry.inquiryMessage}</td>
        <td>${inquiry.phoneNumber}</td>
        
        <td>
            <a href="update.jsp?inquiryID=${inquiry.inquiryID}">
                <button>Update</button>
            </a>
            
            <form action="InquiryDeleteServlet?inquiryID=${inquiry.inquiryID}" method="post" onsubmit="return confirmDelete()">
                <input type="hidden" name="inquiryID" value="${inquiry.inquiryID}" />
                <button>Delete</button>
            </form>
        </td>
        </tr>
        </c:forEach>
    </table>
   <%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>