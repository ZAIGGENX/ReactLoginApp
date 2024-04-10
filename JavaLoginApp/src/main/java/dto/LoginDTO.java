package dto;

public class LoginDTO {

	private String userName;
	private String userPassword;
	
	public LoginDTO() {}
	
	public LoginDTO(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
}