package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.utils.DBUtil;
public class UserRepositoryImpl implements UserRepository {
	
	final String SELECT_USER_BY_PASSWORD = " SELECT * FROM user_tb WHERE id = ? AND password = ? " ;
	final String GET_USER_INFO = " SELECT u.*, s.name FROM user_tb as u LEFT JOIN student_tb AS s ON u.id = s.id where u.id = ? ";
	
	@Override
	public UserDTO getUserbyIdPassword(int username, String password) {
		UserDTO user = null;
		try (Connection conn = DBUtil.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(SELECT_USER_BY_PASSWORD);
			pstmt.setInt(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = UserDTO.builder()
						.id(rs.getInt("id"))
					   .password(rs.getString("password"))
					   .userRole(rs.getString("user_role"))
					   .build();
					   
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public UserDTO getUserInfoById(int userId) {
		UserDTO dto = null;
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(GET_USER_INFO);
			pstmt.setInt(1, userId);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
				dto = UserDTO.builder()
						.id(rs.getInt("id"))
						.password(rs.getString("password"))
						.userRole(rs.getString("user_role"))
						.name(rs.getString("name"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
		

}
