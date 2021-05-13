package com.cg.service;
import com.cg.entity.User;
public interface IUserService {
	public boolean brokerLogin(User user);
	public boolean customerLogin(User user);
	public boolean  userLogout(User user);
	
}
