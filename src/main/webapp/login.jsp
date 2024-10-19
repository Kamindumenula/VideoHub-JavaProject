<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <style>
        /* Unique styles for input fields */
        #username {
            height: 50px; /* Set a fixed height for username input */
            border-radius: 0.5rem; /* Rounded corners for username input */
            border: 2px solid #007bff; /* Blue border for username input */
            padding: 10px; /* Padding for username input */
            font-size: 16px; /* Font size for username input */
        }

        #password {
            height: 50px; /* Set a fixed height for password input */
            border-radius: 0.5rem; /* Rounded corners for password input */
            border: 2px solid #007bff; /* Blue border for password input */
            padding: 10px; /* Padding for password input */
            font-size: 16px; /* Font size for password input */
        }

        .input-group-text {
            cursor: pointer; /* Make the eye icon look clickable */
            border-radius: 0 0.5rem 0.5rem 0; /* Match the rounded corners with the input field */
        }

        /* Button style */
        .btn-custom {
            background-color: #007bff; /* Custom button color */
            color: #fff; /* White text on button */
            height: 50px; /* Match button height with input fields */
            border-radius: 0.5rem; /* Rounded corners for button */
        }

        .btn-custom:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
    <title>Login</title>
    <script>
        function togglePassword() {
            const passwordInput = document.getElementById('password');
            const toggleIcon = document.getElementById('togglePassword');
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.classList.remove('fa-eye-slash'); // Remove slash icon
                toggleIcon.classList.add('fa-eye'); // Show open eye
            } else {
                passwordInput.type = 'password';
                toggleIcon.classList.remove('fa-eye'); // Remove open eye
                toggleIcon.classList.add('fa-eye-slash'); // Show slash icon
            }
        }
    </script>
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center">Login</h2>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="LoginServlet" method="post" class="mt-4">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" name="username" id="username" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <div class="input-group">
                        <input type="password" name="password" id="password" class="form-control" required>
                        <div class="input-group-append">
                            <span class="input-group-text" id="togglePassword" onclick="togglePassword()">
                                <i class="fa fa-eye-slash" aria-hidden="true"></i> 
                            </span>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-custom btn-block">Login</button>
            </form>
            <p class="mt-3 text-center">Don't have an account? <a href="register.jsp">Register here</a></p>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</body>
</html>
