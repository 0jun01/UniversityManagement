package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.*;

public interface StaffRepository {

	// MY 페이지
	void viewMyInfo();
	void changePassword();
	
	// 학사관리 - 모든 학생, 교수 명단
	List<Student> viewAllStudent();
	List<Professor> viewAllProfessor();
	
	// 학사관리 - 학생, 교수 검색 조회
	void viewStudentByIdandNumber();
	void viewProfessorByIdandNumber();
	
	// 학사관리 - 학생, 교수 직원 등록
	void addStudent();
	void addProfessor();
	void addEmployee();
	
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
