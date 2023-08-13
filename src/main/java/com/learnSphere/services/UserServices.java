package com.learnSphere.services;

import com.learnSphere.entity.Users;

public interface UserServices {
	
	//add new users
	String addUsers(Users user);
	
	//check email
	boolean checkEmail(String email);
	
	boolean validate(String email, String password);
	
	String getUserRole(String email);
	
}
