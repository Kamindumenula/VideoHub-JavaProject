<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="header.jsp" %>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Contact Us</title>

    <style>
        body {
            min-height: 100vh;
            background-color: black; /* Changed to black for your design */
            color: white; /* Set text color to white */
        }

        h1 {
            color: white; /* Ensuring header color contrasts with the black background */
            font-size: 2.5em;
            margin-bottom: 20px;
            text-align: center;
        }

        .container {
            margin-top: 50px; /* Added top margin for spacing */
        }
    </style>
</head>
<body>

<div class="container">
    <div class="text-center">
        <h1>
            <i class="fas fa-envelope"></i> Contact Us
        </h1>
        <p>
            Have any questions? Feel free to reach out to us via this inquiry form. We are here to assist with technical issues, content concerns, or any other inquiries.
        </p>
    </div>

    <%
        String inquiryID = request.getParameter("inquiryID");
        String inquiryMessage = request.getParameter("inquiryMessage");
        String phoneNumber = request.getParameter("phoneNumber");
    %>

    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="InquiryInsertServlet" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="inquiryType">
                        <i class="fas fa-question-circle"></i> Inquiry Type:
                    </label>
                    <select id="inquiryType" name="inquiryType" class="form-control" required>
                        <option value="">--Select Inquiry Type--</option>
                        <option value="Tech Related">Tech Related</option>
                        <option value="Content Related">Content Related</option>
                        <option value="Banning Related">Banning Related</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inquiryMessage">
                        <i class="fas fa-comment-alt"></i> Inquiry Message:
                    </label>
                    <input type="text" id="inquiryMessage" name="inquiryMessage" value="<%=inquiryMessage != null ? inquiryMessage : "" %>" required class="form-control">
                </div>
                <div class="form-group">
                    <label for="phoneNumber">
                        <i class="fas fa-phone"></i> Phone Number:
                    </label>
                    <input type="text" id="phoneNumber" name="phoneNumber" value="<%=phoneNumber != null ? phoneNumber : "" %>" required title="Please enter a valid 10-digit phone number" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form>
        </div>
    </div>

    <!-- Icons Section -->
    <div class="text-center mt-4">
        <h2>Contact Information</h2>
        <div class="icon">
            <i class="fas fa-phone" style="font-size: 24px;"></i>
            <p>Call Us: (011) 456-7890</p>
        </div>
        <div class="icon">
            <i class="fas fa-envelope" style="font-size: 24px;"></i>
            <p>Email: videoHubsupport@example.com</p>
        </div>
        <div class="icon">
            <i class="fas fa-map-marker-alt" style="font-size: 24px;"></i>
            <p>Address: 123 Main St, Malabe, Sri Lanka</p>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script>
    function validateForm() {
        var phoneNumber = document.getElementById("phoneNumber").value;
        console.log("Phone Number Entered:", phoneNumber); 
        var phonePattern = /^\d{10}$/; // 10 digits

        if (!phonePattern.test(phoneNumber)) {
            alert("Please enter a valid 10-digit phone number.");
            return false; 
        }

        
        var inquiryType = document.getElementById("inquiryType").value;
        if (inquiryType === "") {
            alert("Please select an inquiry type.");
            return false;
        }

        return true; 
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>