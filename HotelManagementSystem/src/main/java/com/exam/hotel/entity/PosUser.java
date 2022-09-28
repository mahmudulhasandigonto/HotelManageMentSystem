package com.exam.hotel.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class PosUser {
	@Id
	private Long userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userImageUrl;
	@Column(name = "userPosDate", nullable = false, updatable = false)
	@CreationTimestamp
	private Date userPosDate;

	public PosUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PosUser(Long userId, String userName, String userEmail, String userPassword, String userImageUrl,
			Date userPosDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userImageUrl = userImageUrl;
		this.userPosDate = userPosDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public Date getUserPosDate() {
		return userPosDate;
	}

	public void setUserPosDate(Date userPosDate) {
		this.userPosDate = userPosDate;
	}

}
