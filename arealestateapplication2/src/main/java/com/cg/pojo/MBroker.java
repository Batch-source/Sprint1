package com.cg.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MBroker {
	@NotEmpty(message = "Broker Name should not be blank")
	private String broName;
	@NotEmpty(message = "UserId should not be blank")
	private String userid;
	@NotEmpty(message = "Password should not be blank")
	@Size(min = 6, max = 10, message = "Please enter password in range 6 to 10 character")
	private String password;
	@NotEmpty(message = "Role should not be blank")
	private String role;
	@NotEmpty(message = "Mobile No should not be blank")
	@Size(min = 10, message = "please enter 10 digit mobile no")
	private String mobile;
	@NotEmpty(message = "Email Id Name should not be blank")
	private String email;
	@NotEmpty(message = "City should not be blank")
	private String city;

	public String getBroName() {
		return broName;
	}

	public void setBroName(String broName) {
		this.broName = broName;
	}

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

	public MBroker(@NotEmpty(message = "Broker Name should not be blank") String broName,
			@NotEmpty(message = "UserId should not be blank") String userid,
			@NotEmpty(message = "Password should not be blank") @Size(min = 6, max = 10, message = "Please enter password in range 6 to 10 character") String password,
			@NotEmpty(message = "Role should not be blank") String role,
			@NotEmpty(message = "Mobile No should not be blank") @Size(min = 10, message = "please enter 10 digit mobile no") String mobile,
			@NotEmpty(message = "Email Id Name should not be blank") String email,
			@NotEmpty(message = "City should not be blank") String city) {
		super();
		this.broName = broName;
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}

	public MBroker() {
		super();
	}

}
