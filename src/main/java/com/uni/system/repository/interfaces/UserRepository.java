package com.uni.system.repository.interfaces;

import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.UserDTO;

public interface UserRepository {
	
	UserDTO getUserbyIdPassword(int username, String password);
	UserDTO getUserInfoById(int userId); 
	void changePassword(String password, int userId);
	String checkPassword(int userId);
	void updateInfo(int userId, String address, String tel, String email, String userRole);
	
}
	
