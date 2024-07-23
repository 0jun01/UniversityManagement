package com.uni.system.repository.interfaces;

import com.uni.system.repository.model.UserDTO;

public interface UserRepository {
	
	UserDTO getUserbyIdPassword(int username, String password);
	UserDTO getUserInfoById(int userId); 

}
	
