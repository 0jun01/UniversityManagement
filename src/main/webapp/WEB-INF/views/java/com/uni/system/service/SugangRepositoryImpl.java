package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SugangRepository;
import com.uni.system.repository.model.SugangColumn;
import com.uni.system.repository.model.SugangDTO;
import com.uni.system.utils.DBUtil;

public class SugangRepositoryImpl implements SugangRepository{

	@Override
	public List<SugangDTO> getSugangType() {
		String sql = " SELECT DISTINCT(type) FROM subject_tb ";
		
		List<SugangDTO> checkList = new ArrayList<SugangDTO>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SugangDTO check = SugangDTO.builder()
							.type(rs.getString("type"))
							.build();
						checkList.add(check);
						
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkList;
	}

	@Override
	public List<SugangDTO> getSugangDeptName() {
		String sql = " SELECT DISTINCT(name) FROM department_tb ";
		List<SugangDTO> checkList = new ArrayList<SugangDTO>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SugangDTO check = SugangDTO.builder()
							.deptName(rs.getString("name"))
							.build();
							checkList.add(check);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkList;
	}

	@Override
	public List<SugangDTO> getSugangLectureName() {
		String sql = " SELECT DISTINCT(name) FROM subject_tb ";
		List<SugangDTO> checkList = new ArrayList<SugangDTO>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SugangDTO check = SugangDTO.builder()
							.lectureName(rs.getString("name"))
							.build();
							checkList.add(check);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkList;
	}

	
	// TODO 필터 아무것도 선택 안했을시 전체 내용 출력에 사용할 것
	@Override
	public List<SugangColumn> viewSugangColumn(int pageSize, int offset) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = " SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb as sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id " 
				+ "LIMIT ? OFFSET ? ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, pageSize);
				pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
												.collegeName(rs.getString("college_name"))
												.deptName(rs.getString("dept_name"))
												.subjectId(rs.getInt("subject_id"))
												.type(rs.getString("type"))
												.subjectName(rs.getString("subject_name"))
												.professorName(rs.getString("professor_name"))
												.grades(rs.getInt("grades"))
												.subDay(rs.getString("sub_day"))
												.startTime(rs.getInt("start_time"))
												.endTime(rs.getInt("end_time"))
												.roomId(rs.getString("room_id"))
												.numOfStudent(rs.getInt("num_of_student"))
												.capacity(rs.getInt("capacity"))
												.build();
											sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectType(String type) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ?" ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, type);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectDept(String departName) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE dept.name = ?" ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, departName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectLectureName(String lectureName) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.name = ?" ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, lectureName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectTypeAndDept(String type, String deptName) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? AND dept.name = ? " ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, type);
				pstmt.setString(2, deptName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectDeptAndLectureName(String deptName, String lectureName) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE dept.name = ? AND sub.name = ? " ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, deptName);
				pstmt.setString(2, lectureName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectTypeAndLectureName(String type, String lectureName) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? AND sub.name = ? " ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, type);
				pstmt.setString(2, lectureName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public List<SugangColumn> selectAllFilter(String type, String deptName, String lectureName) {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = "SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? AND dept.name = ? AND sub.name = ? " ;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, type);
				pstmt.setString(2, deptName);
				pstmt.setString(3, lectureName);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SugangColumn sugangDTO = SugangColumn.builder()
							.collegeName(rs.getString("college_name"))
							.deptName(rs.getString("dept_name"))
							.subjectId(rs.getInt("subject_id"))
							.type(rs.getString("type"))
							.subjectName(rs.getString("subject_name"))
							.professorName(rs.getString("professor_name"))
							.grades(rs.getInt("grades"))
							.subDay(rs.getString("sub_day"))
							.startTime(rs.getInt("start_time"))
							.endTime(rs.getInt("end_time"))
							.roomId(rs.getString("room_id"))
							.numOfStudent(rs.getInt("num_of_student"))
							.capacity(rs.getInt("capacity"))
							.build();
						sugangList.add(sugangDTO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}
	
	@Override
	public List<SugangColumn> viewSugangValues() {
		List<SugangColumn> sugangList = new ArrayList<SugangColumn>();
		String sql = " SELECT coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.sub_day,sub.start_time,sub.end_time,sub.room_id ,sub.num_of_student, sub.capacity "
				+ "FROM subject_tb as sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id " ;
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				SugangColumn sugangDTO = SugangColumn.builder()
						.collegeName(rs.getString("college_name"))
						.deptName(rs.getString("dept_name"))
						.subjectId(rs.getInt("subject_id"))
						.type(rs.getString("type"))
						.subjectName(rs.getString("subject_name"))
						.professorName(rs.getString("professor_name"))
						.grades(rs.getInt("grades"))
						.subDay(rs.getString("sub_day"))
						.startTime(rs.getInt("start_time"))
						.endTime(rs.getInt("end_time"))
						.roomId(rs.getString("room_id"))
						.numOfStudent(rs.getInt("num_of_student"))
						.capacity(rs.getInt("capacity"))
						.build();
				sugangList.add(sugangDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sugangList;
	}

	@Override
	public int getAllCount() {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id ";
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}


	@Override
	public int getSelectedTypeCount(String type) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, type);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int getSelectedDeptId(String deptId) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE dept.name = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, deptId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;

	}

	@Override
	public int getSelectedLectureName(String lectureName) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.name = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, lectureName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int getSelectedTypeAndDept(String type, String deptId) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? AND dept.name = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, type);
				pstmt.setString(2, deptId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int getSelectedDeptAndLectureNameCount(String deptId, String lectureName) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE dept.name = ? AND sub.name = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, deptId);
				pstmt.setString(2, lectureName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int getSelectedTypeAndLectureNameCount(String type, String lectureName) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? AND sub.name = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, type);
				pstmt.setString(2, lectureName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int getSelectedAll(String type, String deptId, String lectureName) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.type = ? AND dept.name = ? AND sub.name = ? ";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setString(1, type);
				pstmt.setString(2, deptId);
				pstmt.setString(3, lectureName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
				rowCount = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}



}
