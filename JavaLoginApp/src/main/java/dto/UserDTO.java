package dto;

public class UserDTO {
	
	private int userId;
	private String userName;
	private String userPassword;
	private String userMail;
	
	public UserDTO(int userId, String userName, String userPassword, String userMail) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMail = userMail;
	}

	public UserDTO() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userMail="
				+ userMail + "]";
	}
	
}
