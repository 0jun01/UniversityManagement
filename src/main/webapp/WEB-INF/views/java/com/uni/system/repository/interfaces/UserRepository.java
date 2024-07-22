package com.uni.system.repository.interfaces;

import com.uni.system.repository.model.User;
import com.uni.system.repository.model.UserDTO;

public interface UserRepository {
	
	UserDTO getUserbyUsername(int username, String password);
	UserDTO getUserbyRole(int userId); 

}
	
