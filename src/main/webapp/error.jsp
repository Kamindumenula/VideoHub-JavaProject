<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Occurred</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <style>
        body {
            font-family: 'Verdana', sans-serif;
            background-color: #f2f2f2;
            color: #333;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-danger">An Error Occurred</h1>
        <p>We encountered an unexpected error while processing your request.</p>
        <p>Error details: <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "Unknown error" %></p>
        <p>Please try again later or contact support if the issue persists.</p>
        <a href="userProfile.jsp" class="btn btn-primary">Back to Profile</a>
    </div>
</body>
</html>
