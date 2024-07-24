package com.uni.system.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SubjectRepository;
import com.uni.system.repository.model.SubjectLectureList;
import com.uni.system.utils.DBUtil;

public class SubjectRepositoryImpl implements SubjectRepository {

	@Override
	public List<SubjectLectureList> selectByYearAndSemester(int year, int semester) {
		String sql = " SELECT sub.sub_year, sub.semester, coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.sub_year = ? AND sub.semester = ? " ;
		List<SubjectLectureList> subjectList = new ArrayList<SubjectLectureList>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        // 쿼리와 파라미터 로그

			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectLectureList sbList = SubjectLectureList.builder()
						.subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester"))
						.collegeName(rs.getString("college_name"))
						.departmentName(rs.getString("dept_name"))
						.haksuNum(rs.getInt("subject_id"))
						.type(rs.getString("type"))
						.lectureName(rs.getString("subject_name"))
						.professorName(rs.getString("professor_name"))
						.grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("num_of_student"))
						.build();
				subjectList.add(sbList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	// TODO 쿼리에 파라미터 추가하기
	@Override
	public List<SubjectLectureList> selectBySemesterAndDeptAndName(int year, int semester, int deptId) {
		String sql = " SELECT sub.sub_year, sub.semester, coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.sub_year = ? AND sub.semester = ? AND dept.id = ? " ;
		List<SubjectLectureList> subjectList = new ArrayList<SubjectLectureList>();
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, deptId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectLectureList sbList = SubjectLectureList.builder()
						.subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester"))
						.collegeName(rs.getString("college_name"))
						.departmentName(rs.getString("dept_name"))
						.haksuNum(rs.getInt("subject_id"))
						.type(rs.getString("type"))
						.lectureName(rs.getString("subject_name"))
						.professorName(rs.getString("professor_name"))
						.grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("num_of_student"))
						.build();
				subjectList.add(sbList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	// TODO 쿼리에 파라미터 추가하기
	@Override
	public List<SubjectLectureList> selectBySemesterAndDeptAndNameAndTpye(int year, int semester, int deptId,
			String lectureName) {
		String sql = " SELECT sub.sub_year, sub.semester, coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.sub_year = ? AND sub.semester = ? AND dept.id = ? AND sub.name = ? " ;
		List<SubjectLectureList> subjectList = new ArrayList<SubjectLectureList>();
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			pstmt.setInt(3, deptId);
			pstmt.setString(4, lectureName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectLectureList sbList = SubjectLectureList.builder()
						.subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester"))
						.collegeName(rs.getString("college_name"))
						.departmentName(rs.getString("dept_name"))
						.haksuNum(rs.getInt("subject_id"))
						.type(rs.getString("type"))
						.lectureName(rs.getString("subject_name"))
						.professorName(rs.getString("professor_name"))
						.grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("num_of_student"))
						.build();
				subjectList.add(sbList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}
	
	// 개설학과만 선택하지 않았을 경우
	@Override
	public List<SubjectLectureList> selectByYearAndSemesterAndType(int year, int semester, String lectureName) {
		String sql = " SELECT sub.sub_year, sub.semester, coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.num_of_student, sub.capacity "
				+ "FROM subject_tb AS sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.sub_year = ? AND sub.semester = ?  AND sub.name = ? " ;
		
		List<SubjectLectureList> subjectList = new ArrayList<SubjectLectureList>();
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, year);
			pstmt.setInt(2, semester);
			pstmt.setString(3 , lectureName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				SubjectLectureList sbList = SubjectLectureList.builder()
						.subYear(rs.getInt("sub_year"))
						.semester(rs.getInt("semester"))
						.collegeName(rs.getString("college_name"))
						.departmentName(rs.getString("dept_name"))
						.haksuNum(rs.getInt("subject_id"))
						.type(rs.getString("type"))
						.lectureName(rs.getString("subject_name"))
						.professorName(rs.getString("professor_name"))
						.grades(rs.getInt("grades"))
						.capacity(rs.getInt("capacity"))
						.numOfStudent(rs.getInt("num_of_student"))
						.build();
				subjectList.add(sbList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}
	
	@Override
	public List<SubjectLectureList> selectAllTable(int limit, int offset) {
		String sql = " SELECT sub.sub_year, sub.semester, coll.name AS college_name, dept.name AS dept_name, sub.id AS subject_id, sub.type, sub.name AS subject_name, pro.name AS professor_name, sub.grades, sub.num_of_student, sub.capacity "
				+ "FROM subject_tb as sub "
				+ "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
				+ "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
				+ "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "LIMIT ? OFFSET ? ";
		List<SubjectLectureList> subjectList = new ArrayList<SubjectLectureList>();
		try (Connection conn= DBUtil.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				SubjectLectureList sbList = SubjectLectureList.builder()
											.subYear(rs.getInt("sub_year"))
											.semester(rs.getInt("semester"))
											.collegeName(rs.getString("college_name"))
											.departmentName(rs.getString("dept_name"))
											.haksuNum(rs.getInt("subject_id"))
											.type(rs.getString("type"))
											.lectureName(rs.getString("subject_name"))
											.professorName(rs.getString("professor_name"))
											.grades(rs.getInt("grades"))
											.capacity(rs.getInt("capacity"))
											.numOfStudent(rs.getInt("num_of_student"))
											.build();
											subjectList.add(sbList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	@Override
	public int getAllLectureCount() {
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
	public int getByYearAndSemesterCount(int year, int semester) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
	            + "FROM subject_tb AS sub "
	            + "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
	            + "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
	            + "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.sub_year = ? AND sub.semester = ? " ;
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setInt(1, year);
				pstmt.setInt(2, semester);
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
	public int getBySemesterAndDeptAndNameCount(int year, int semester, int deptId) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
	            + "FROM subject_tb AS sub "
	            + "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
	            + "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
	            + "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
				+ "WHERE sub.sub_year = ? AND sub.semester = ? AND dept.id = ? " ;
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setInt(1, year);
				pstmt.setInt(2, semester);
				pstmt.setInt(3, deptId);
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
	public int getBySemesterAndDeptAndNameAndTypeCount(int year, int semester, int deptId, String lectureName) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
	            + "FROM subject_tb AS sub "
	            + "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
	            + "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
	            + "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
	            + "WHERE sub.sub_year = ? AND sub.semester = ? AND dept.id = ? AND sub.name = ? " ;
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setInt(1, year);
				pstmt.setInt(2, semester);
				pstmt.setInt(3, deptId);
				pstmt.setString(4, lectureName);
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
	public int getByYearAndSemesterAndTypeCount(int year, int semester, String lectureName) {
		int rowCount = 0;
		String query = " SELECT count(*) AS row_count "
	            + "FROM subject_tb AS sub "
	            + "LEFT JOIN professor_tb AS pro ON pro.id = sub.professor_id "
	            + "LEFT JOIN department_tb AS dept ON dept.id = sub.dept_id "
	            + "LEFT JOIN college_tb AS coll ON coll.id = dept.college_id "
	            + "WHERE sub.sub_year = ? AND sub.semester = ?  AND sub.name = ? " ;
		try (Connection conn=DBUtil.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
				pstmt.setInt(1, year);
				pstmt.setInt(2, semester);
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