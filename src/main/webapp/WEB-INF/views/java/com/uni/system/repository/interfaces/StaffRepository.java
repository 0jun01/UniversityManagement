package com.uni.system.repository.interfaces;

import java.sql.Date;
import java.util.List;

import com.uni.system.repository.model.*;

public interface StaffRepository {

	// MY 페이지
	Staff viewMyInfo(int userId);
	void changePassword(String password, int userId);
	
	// 학사관리 - 모든 학생, 교수 명단
	List<Student> viewAllStudent(int limit, int offset);
	int getAllStudentLectureCount();
	List<Professor> viewAllProfessor(int limit, int offset);
	int getAllProfessorLectureCount();
	
	// 학사관리 - 학생, 교수 검색 조회
	void viewStudentByIdandNumber();
	void viewProfessorByIdandNumber();
	
	// 학사관리 - 학생, 교수 직원 등록
	void addStudent(String name, Date birthDate, String gender, String address, String tel, String email, int deptId, Date entraceDate);
	void addProfessor(String name, Date birthDate, String gender, String address, String tel, String email, int deptId);
	void addStaff(String name, Date birthDate, String gender, String address, String tel, String email);
	
	// TODO 학사관리 - 등록금 고지서 발송
	
	// 학사관리 - 휴학처리
	void viewAllBreak();
	
	// TODO 학사관리 - 수강 신청 기간 설청
	
	// 등록
	void addCollege();
	void addDepartment();
	void addClassRoom();
	void addClass();
	void addtuition();
	
	// 학사정보
	
	List<Notice> viewNotice();
	void viewAcademicSchedule();
	
}
