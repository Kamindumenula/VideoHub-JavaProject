<header style="background-color: #000; color: #fff;">


    <nav class="navbar navbar-expand-lg" id="navbar" style="background-color: #000; color: #fff;">
        <a class="navbar-brand" href="index.jsp" style="color: #fff;">VideoHub</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" style="border: none;">
            <span class="navbar-toggler-icon" style="background-color: #fff;"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp" style="color: #fff;">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="about.jsp" style="color: #fff;">About</a></li>
                <li class="nav-item"><a class="nav-link" href="contact.jsp" style="color: #fff;">Contact</a></li>
                <li class="nav-item"><a class="nav-link" href="login.jsp" style="color: #fff;">Login</a></li>
            </ul>
            <!-- Profile Icon -->
            <ul class="navbar-nav ml-3">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="profileDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: #fff;">
                        <img src="images/profile_icon.png" alt="Profile" style="width:30px; height:30px; border-radius:50%;">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="profileDropdown" style="background-color: #333; color: #fff;">
                        <a class="dropdown-item" href="userProfile.jsp" style="color: #fff;">Profile</a>
             
                        <div class="dropdown-divider" style="background-color: #555;"></div>
                        <a class="dropdown-item" href="LogoutServlet" style="color: #fff;">Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>
