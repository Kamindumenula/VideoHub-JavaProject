package videoHubPackage;

public class UserModel {
	
	private int userID;
	private String fullname;
	private String username;
	private String email;
	private String password;
	
	
	public UserModel(int userID, String fullname, String username, String email, String password) {
		super();
		this.userID = userID;
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

}