<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Verdana', sans-serif;
        background-color: #2c2c2c; /* Dark charcoal */
        color: #f5f5f5; /* Light silver */
        padding: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        padding: 10px;
        background-color: #3c3c3c; /* Slightly lighter charcoal */
        border-radius: 10px;
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
    }

    form {
        background-color: #3c3c3c; /* Slightly lighter charcoal */
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.5);
        max-width: 500px;
        margin: 0 auto; /* Center the form */
    }

    table {
        width: 100%;
        border-spacing: 0 10px; /* Adds space between table rows */
    }

    td {
        padding: 12px;
    }

    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #555555; /* Darker gray */
        border-radius: 10px;
        font-size: 16px;
        background-color: #4d4d4d; /* Dark gray */
        color: #f5f5f5; /* Light silver */
        transition: background-color 0.3s, box-shadow 0.3s;
    }

    input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus {
        background-color: #5d5d5d; /* Slightly lighter gray */
        box-shadow: 0 0 8px rgba(0, 229, 255, 0.6); /* Neon cyan shadow */
        border-color: #00e5ff; /* Neon cyan */
        outline: none; /* Removes default focus outline */
    }

    /* Error message styles */
    .error {
        color: #ff4d4d; /* Red for error messages */
        display: none; /* Hidden by default */
        font-size: 12px;
        margin-top: 5px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 15px;
        background-color: #00e5ff; /* Neon cyan */
        color: #2c2c2c; /* Dark background */
        border: none;
        border-radius: 10px;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.2s ease;
        box-shadow: 0 5px 10px rgba(0, 229, 255, 0.5); /* Button shadow */
    }

    input[type="submit"]:hover {
        background-color: #d500f9; /* Electric purple */
        transform: translateY(-2px); /* Hover lift effect */
    }

    input[type="submit"]:active {
        transform: translateY(0);
    }

    /* Responsive design */
    @media (max-width: 600px) {
        body {
            padding: 10px; /* Adjusted padding for smaller screens */
        }

        h1 {
            font-size: 2em; /* Smaller heading for smaller screens */
        }

        td {
            padding: 10px; /* Increased padding for smaller screens */
        }
    }
</style>
</head>
<body>

<h1>Update User Details</h1>

<%
String userID = request.getParameter("userID");
String fullname = request.getParameter("fullname");
String username = request.getParameter("username");
String email = request.getParameter("email");
String password = request.getParameter("password");
%>

<form name="updateForm" action="UserUpdateServlet" method="post">
<table>
<tr>
  <td>User ID:</td>
  <td><input type="text" name="userID" value="<%= userID %>" readonly></td>
</tr>

<tr>
  <td>Full Name:</td>
  <td>
      <input type="text" name="fullname" value="<%= fullname %>" required>
      <p id="fullnameError" class="error">Full Name must be more than 5 characters</p>
  </td>
</tr>

<tr>
  <td>Username:</td>
  <td>
      <input type="text" name="username" value="<%= username %>" required>
      <p id="usernameError" class="error">Username must be more than 5 characters</p>
  </td>
</tr>

<tr>
  <td>Email:</td>
  <td><input type="email" name="email" value="<%= email %>" required></td>
</tr>

<tr>
  <td>Password:</td>
  <td>
      <input type="password" name="password" value="<%= password %>" required>
      <p id="passwordError" class="error">Password must be more than 5 characters</p>
  </td>
</tr>

<tr>
  <td colspan="2"><input type="submit" value="Update"></td>
</tr>
</table>
</form>
<%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>