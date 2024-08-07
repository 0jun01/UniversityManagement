package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.utils.DBUtil;
public class UserRepositoryImpl implements UserRepository {
	
	final String SELECT_USER_BY_PASSWORD = " SELECT * FROM user_tb WHERE id = ? AND password = ? " ;
	final String GET_USER_INFO = " SELECT u.*, s.name AS studentName, p.name AS professorName, f.name as staffName FROM user_tb AS u LEFT JOIN student_tb AS s ON u.id = s.id LEFT JOIN professor_tb AS p ON u.id = p.id LEFT JOIN staff_tb AS f ON u.id = f.id WHERE u.id = ?	";
	final String CHANGE_PASSWORD = " UPDATE user_tb SET password = ? WHERE id = ? ";
	final String SELECT_PASSWORD = " SELECT password FROM user_tb WHERE id = ? ";
	final String CHANGE_INFO_STUDENT = " UPDATE student_tb SET address = ? ,email =  ?, tel= ? WHERE id = ? " ;
	final String CHANGE_INFO_STAFF = " UPDATE staff_tb SET address = ? ,email =  ?, tel= ? WHERE id = ? " ;
	final String CHANGE_INFO_PROFESSOR = " UPDATE professor_tb SET address = ? ,email =  ?, tel= ? WHERE id = ? " ;
	
	
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
						.name(rs.getString("studentName"))
						.staffName(rs.getString("staffName"))
						.professorName(rs.getString("professorName"))
						.build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void changePassword(String password, int userId) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(CHANGE_PASSWORD)) {
				pstmt.setString(1, password);
				pstmt.setInt(2, userId);
				pstmt.executeUpdate();
				conn.commit();
				
			} catch (Exception e) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String checkPassword(int userId) {
		String password = null;
		try (Connection conn = DBUtil.getConnection()){
			try(PreparedStatement pstmt = conn.prepareStatement(SELECT_PASSWORD)) {
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				System.out.println(rs.getRow());

				if(rs.next()) {
					password = rs.getString("password");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return password;
	}

	@Override
	public void updateInfo(int userId, String address, String tel, String email, String userRole) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			String query = null;
			if(userRole.equalsIgnoreCase("student")) {
				query = CHANGE_INFO_STUDENT;
			} else if(userRole.equalsIgnoreCase("professor")){
				query = CHANGE_INFO_PROFESSOR;
			} else if(userRole.equalsIgnoreCase("staff")){
				query = CHANGE_INFO_STAFF;
			}
			try (PreparedStatement pstmt = conn.prepareStatement(query)){
				pstmt.setString(1, address);
				pstmt.setString(2, email);
				pstmt.setString(3, tel);
				pstmt.setInt(4, userId);
				int rowCount = pstmt.executeUpdate();
				System.out.println("카운" + rowCount);
				conn.commit();
				
				
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		

}
