<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>User Details Form</title>

    <style>
        body {
            min-height: 100vh;
            background-color: #f5f5f5;
        }

        h2 {
            color: #3c3c3c;
            font-size: 2.5em;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2>Enter User Details</h2>
            <form action="UserInsertServlet" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="fullname" style="color:black">Full Name:</label>
                    <input type="text" class="form-control" id="fullname" name="fullname" placeholder="John Doe" required>
                </div>
                <div class="form-group">
                    <label for="username" style="color:black">User Name:</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="johndoe" required>
                </div>
                <div class="form-group">
                    <label for="email" style="color:black">Email Address:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="example@domain.com" required>
                </div>
                <div class="form-group">
                    <label for="password" style="color:black">Set Password:</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    function validateForm() {
        var fullname = document.getElementById("fullname").value;
        var password = document.getElementById("password").value;
        
        // Full name validation: Only letters and spaces allowed
        var namePattern = /^[A-Za-z\s]+$/;
        if (!namePattern.test(fullname)) {
            alert("Full Name must contain only letters and spaces.");
            return false;
        }

        // Password validation: At least 5 characters
        if (password.length < 5) {
            alert("Password must be at least 5 characters long.");
            return false;
        }

        return true;
    }
</script>
</body>
</html>