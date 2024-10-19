<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Video</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
</head>
<body>
    <h2 style="text-align: center;">Edit Video</h2>

<%
String videoID = request.getParameter("videoID");
String videoName = request.getParameter("videoName");
String description = request.getParameter("description");
%>

  
    <form action="VideoEditServlet" method="post" style="width: 50%; margin: 20px auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; background-color: #f9f9f9; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
    <input type="hidden" name="videoID" value="<%= videoID %>" readonly>


    <label for="videoName" style="color: black;display: block; margin-bottom: 10px; font-weight: bold;">Video Name:</label>
    <input type="text" id="videoName" name="videoName" value="<%= videoName %>" required 
           style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px;"/><br>

    <label for="description" style="color: black;display: block; margin-bottom: 10px; font-weight: bold;">Description:</label>
    <textarea id="description" name="description" required 
              style="width: 100%; padding: 8px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 4px; height: 100px;"><%= description %></textarea><br>

    <button type="submit" style="padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">
        Save Changes
    </button>
</form>


    <%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
