package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.StudentRepository;
import com.uni.system.repository.model.BreakApp;
import com.uni.system.repository.model.Grade;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.Subject;
import com.uni.system.utils.DBUtil;

public class StudentRepositoryImpl implements StudentRepository{
	
	Query query;
	private String STUDENT_INFO = "SELECT s.*, c.name as college, d.name as department FROM college_tb as c LEFT JOIN department_tb AS d ON c.id = d.college_id LEFT JOIN student_tb as s on s.dept_id = d.id where s.id = ? ";
	private String CHANGE_PASSWORD = " UPDATE user_tb SET password = ? WHERE id = ? ";
	
	@Override
	public Student viewMyInfo(int userid) {
		Student student = null;
		try (Connection conn = DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(STUDENT_INFO)){
				pstmt.setInt(1, userid);
				ResultSet rs =  pstmt.executeQuery();
				if(rs.next()) {
					student = Student.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.birthDate(rs.getDate("birth_Date"))
							.gender(rs.getString("gender"))
							.address(rs.getString("address"))
							.tel(rs.getString("tel"))
							.email(rs.getString("email"))
							.deptId(rs.getInt("dept_id"))
							.grade(rs.getInt("grade"))
							.semester(rs.getInt("semester"))
							.entranceDate(rs.getDate("entrance_date"))
							.graduationDate(rs.getDate("graduation_date"))
							.college(rs.getString("college"))
							.department(rs.getString("department"))
							.build();
				}
				
			} catch (Exception e) {
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
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
	public void addBreak() {
		
	}

	@Override
	public List<BreakApp> viewAllBreak() {
		return null;
	}

	@Override
	public void viewTuition() {
		
	}

	@Override
	public void tuitionbill() {
		
	}

	@Override
	public List<Subject> viewAllClass() {
		List<Subject> subjectList = new ArrayList<Subject>();
		// SELECT 
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query.VIEW_ALL_CLASS);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Subject subject = new Subject().builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.professorId(rs.getInt("professorId"))
						.roomId(rs.getString("roomId"))
						.deptId(rs.getInt("deptId"))
						.type(rs.getString("type"))
						.subYear(rs.getInt("subYear"))
						.semester(rs.getInt("semester"))
						.subDay(rs.getString("subDay"))
						.startTime(rs.getInt("startTime"))
						.endTime(rs.getInt("endTime"))
						.grades(rs.getInt("grade"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("numOfStudent"))
						.build();
				subjectList.add(subject);
				
			}
			
		} catch (Exception e) {

		}
		return subjectList;
	}

	@Override
	public void viewAllClassSchedule() {
		
	}

	@Override
	public void addBeforehandToDoCourse() {
		
	}

	@Override
	public void addToDoCourse() {
		
	}

	@Override
	public void viewToDoCourse() {
		
	}

	@Override
	public void viewScore() {
		
	}

	@Override
	public void viewScoreBySemester() {
		
	}

	@Override
	public List<Grade> viewAllScore() {
		return null;
	}

	@Override
	public List<Notice> viewNotice() {
		return null;
	}

	@Override
	public void viewAcademicSchedule() {
		
	}
	

	

}
