package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name = "user_id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name = "user_name", length = 256)
	private String userName;
	
	@Column(name = "user_password", length = 256)
	private String userPassword;
	
	@Column(name = "user_mail", length = 256)
	private String userMail;

	public User(int userId, String userName, String userPassword, String userMail) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMail = userMail;
	}

	public User() {}

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
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userMail="
				+ userMail + "]";
	}
	
}
