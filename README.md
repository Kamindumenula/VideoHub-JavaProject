# VideoHub

**VideoHub** is an online video browsing system built using Java, JSP, Servlets, MySQL, and Bootstrap. It allows users to register, log in, and manage their video content through various CRUD operations. The application also includes admin functionalities to manage users and inquiries.

## Features

- **User Registration and Login**: Users can create accounts and log in to the system.
- **User Profile Management**: Users can update and manage their profile information.
- **Video Management**: Users can upload, edit, delete, and view their videos.
- **Inquiry System**: Users can send inquiries, and admins can manage (CRUD) these inquiries.
- **Admin Dashboard**: Admins have the ability to manage users (CRUD operations) and view/manage inquiries.
- **Responsive Design**: The application uses Bootstrap for a responsive and user-friendly interface.

## Technologies Used

- **Backend**: Java, JSP, Servlets
- **Frontend**: HTML, CSS, Bootstrap
- **Database**: MySQL (MySQL Workbench 8.0 CE)
- **Server**: Apache Tomcat 9.0

## Database Configuration

Ensure that you have MySQL installed and create a database with the name `videohub`. Import the required SQL script provided with the project to set up the necessary tables and data.

## Running the Project Locally

Follow these steps to run the project locally:

1. **Import the project into Eclipse IDE** as a **Dynamic Web Project**.

2. **Add the external libraries** to the classpath:
   - MySQL Connector JAR (`mysql-connector-java-8.0.x.jar`)
   - Any other required libraries mentioned in the `lib` folder.

3. **Configure Apache Tomcat 9.0** in Eclipse as the server for this project. Ensure that the port numbers match those used in your project (usually `8080`).

4. **Update the database configuration** in your Java classes to ensure it matches your local MySQL server details:
   - Host: `localhost`
   - Port: `3306`
   - Database Name: `videohub`
   - Username and Password: *(update with your MySQL credentials)*

5. **Deploy the project** on Tomcat and start the server. You should now be able to access the application by navigating to:
http://localhost:8080/VideoHub/


## Usage

- **Register** as a new user to gain access to the application.
- **Log in** to view and manage your video content through the user dashboard.
- **Admin users** can log in using their credentials to access the admin dashboard where they can manage users and inquiries.

## Other Contributors 

- **Akalanka Gunathilake** - Video CRUD  
  GitHub: [Akalanka Gunathilake](https://github.com/Akalankagunathilake2002)
- **Thenura Jayarathna** - User Registration, User Profile, Update/Delete User Details
  GitHub: [Thenura Jayarathna](https://github.com/Thenura68)
- **Bimalka Bandara** - Inquiry CRUD
  GitHub: [Bimalka Bandara]()

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Git Commands to Upload the Project

```bash
# Navigate to your project directory
cd C:\Projects\Video Browsing System

# Add the README.md file and any other changes to the staging area
git add README.md

# Commit the changes with a message
git commit -m "Add README file"

# Push the changes to your GitHub repository
git push origin master

