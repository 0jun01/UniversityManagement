package com.uni.system.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.BreakAppRepository;
import com.uni.system.repository.model.BreakApp;
import com.uni.system.utils.DBUtil;

public class BreakAppRepositoryImpl implements BreakAppRepository {

	final String ADD_BREAK = " INSERT INTO break_app_tb(student_id, student_grade, from_year, from_semester, to_year, to_semester, type, app_date) VALUES (?, ?, ?, ?, ?, ?, ?, now());";
	final String SHOW_BREAK = " SELECT * FROM break_app_tb WHERE student_id = ? ";
	final String CHECK_DUPLICATE = " SELECT student_id FROM break_app_tb WHERE student_id = ? ";
	
	@Override
	public void addBreak(int studentId, int grade, int fromYear, int fromSemester, int toYear, int toSemester, String type) {
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(ADD_BREAK)){
				pstmt.setInt(1, studentId);
				pstmt.setInt(2, grade);
				pstmt.setInt(3, fromYear);
				pstmt.setInt(4, fromSemester);
				pstmt.setInt(5, toYear);
				pstmt.setInt(6, toSemester);
				pstmt.setString(7, type);
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
	public List<BreakApp> showBreadList(int userId) {
		List<BreakApp> breakList = new ArrayList<BreakApp>();
		try (Connection conn = DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(SHOW_BREAK)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					BreakApp breakApp = BreakApp.builder()
							.studentId(rs.getInt("student_id"))
							.studentGrade(rs.getInt("student_grade"))
							.fromYear(rs.getInt("from_year"))
							.fromSemester(rs.getInt("from_semester"))
							.toYear(rs.getInt("to_year"))
							.toSemester(rs.getInt("to_semester"))
							.type(rs.getString("type"))
							.appDate(rs.getDate("app_date"))
							.status(rs.getString("status"))
							.build();
					breakList.add(breakApp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return breakList;
	}

	@Override
	public BreakApp checkDuplicate(int userId) {
		BreakApp breakApp = null;
		try (Connection conn= DBUtil.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(CHECK_DUPLICATE)){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					breakApp = BreakApp.builder()
							.studentId(rs.getInt("student_id"))
							.build();
				}
			} catch (Exception e) {
			
			}
		} catch (Exception e) {
	
		}
		return breakApp;
	}

}
