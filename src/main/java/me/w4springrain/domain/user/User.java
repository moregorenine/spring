package me.w4springrain.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
	private Integer userId;
	@NotNull @Min(2) @Max(16)
	private String password;
	@NotNull @Email
	private String email;

	public User() {
	}

	public User(Integer userId) {
		this.setUserId(userId);
	}

	public User(Integer userId, String password, String email) {
		this.setUserId(userId);
		this.setPassword(password);
		this.setEmail(email);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [email=" + email + "]";
	}

}