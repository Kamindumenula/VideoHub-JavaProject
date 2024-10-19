<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, videoHubPackage.VideoControl, videoHubPackage.VideoModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VideoHub</title>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
    <%@ include file="header.jsp" %>
    <style>
        .video-img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 10px 10px 0 0;
        }
        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s, box-shadow 0.3s;
            cursor: pointer; /* Make cards clickable */
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }
        .card-title {
            color: black;
            font-weight: bold;
        }
        .card-text {
            color: black;
        }
        .alert {
            display: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="mt-4 text-center">Welcome to VideoHub</h1>
    <p class="lead text-center">Browse and watch your favorite videos!</p>

    <div class="row mb-4">
        <div class="col-md-8 offset-md-2">
            <div class="input-group">
                <input type="text" class="form-control" id="searchBar" onkeyup="searchVideos()" placeholder="Search videos..." aria-label="Search videos">
                <div class="input-group-append">
                    <button class="btn btn-outline-primary" type="button">Search</button>
                </div>
            </div>
            <div id="noResultAlert" class="alert alert-danger mt-2">There are no videos with this name.</div>
        </div>
    </div>

    <div class="row" id="videoList">
        <%
            VideoControl control = new VideoControl();
            List<VideoModel> videos = control.GetAllDBVideos();
            for (VideoModel video : videos) {
        %>
            <div class="col-md-4 video-card">
                <div class="card mb-4 shadow-sm" onclick="window.location='viewVideo.jsp?id=<%= video.getVideoID() %>'"> <!-- Redirect on click -->
                    <img src="<%= request.getContextPath() %>/thumbnails/<%= video.getThumbnailFilename() %>" class="video-img" alt="<%= video.getVideoName() %>">

                    <div class="card-body">
                        <h5 class="card-title"><%= video.getVideoName() %></h5>
                        <p class="card-text"><%= video.getDescription() %></p>
                    </div>
                </div>
            </div>
        <%
            }
        %>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="js/script.js"></script>
<script>
    function searchVideos() {
        var input, filter, cards, title, i, txtValue;
        input = document.getElementById('searchBar');
        filter = input.value.toUpperCase();
        cards = document.getElementsByClassName('video-card');
        var noResultAlert = document.getElementById('noResultAlert');
        var hasResult = false;

        for (i = 0; i < cards.length; i++) {
            title = cards[i].getElementsByClassName('card-title')[0];
            txtValue = title.textContent || title.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                cards[i].style.display = "";
                hasResult = true;
            } else {
                cards[i].style.display = "none";
            }
        }

        if (!hasResult && input.value.trim() !== "") {
            noResultAlert.style.display = "block"; 
        } else {
            noResultAlert.style.display = "none"; 
        }
    }
</script>
</body>
</html>
