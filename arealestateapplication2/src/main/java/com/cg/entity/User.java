package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	@Id
	private String userid;
	private String password;
	private String role;
	private String mobile;
	private String email;
	private String city;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User(String userid, String password, String role, String mobile, String email, String city) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", role=" + role + ", mobile=" + mobile
				+ ", email=" + email + ", city=" + city + "]";
	}
}
