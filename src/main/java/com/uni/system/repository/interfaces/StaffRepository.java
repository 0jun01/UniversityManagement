package com.uni.system.repository.interfaces;

import java.sql.Date;
import java.util.List;

import com.uni.system.repository.model.BreakApp;
import com.uni.system.repository.model.College;
import com.uni.system.repository.model.Department;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Room;
import com.uni.system.repository.model.Staff;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.Subject;

public interface StaffRepository {

	// MY 페이지
	Staff viewMyInfo(int userId);

	void changePassword(String password, int userId);

	void changeInfomation(String address, int tel, String email, int userId);

	// 학사관리 - 모든 학생, 교수 명단
	List<Student> viewAllStudent(int limit, int offset);

	int getAllStudentLectureCount();

	List<Professor> viewAllProfessor(int limit, int offset);

	int getAllProfessorLectureCount();

	// 학사관리 - 학생, 교수 검색 조회
	void viewStudentByIdandNumber();

	void viewProfessorByIdandNumber();

	// 학사관리 - 학생, 교수 직원 등록
	void addStudent(String name, Date birthDate, String gender, String address, String tel, String email, int deptId,
			Date entraceDate);

	void addProfessor(String name, Date birthDate, String gender, String address, String tel, String email, int deptId);

	void addStaff(String name, Date birthDate, String gender, String address, String tel, String email);

	// 학사관리 - 휴학처리
	List<BreakApp> viewAllBreak();

	void processBreak(int userId);
	// TODO 학사관리 - 수강 신청 기간 설청

	// 등록
	void addDepartment();

	void addClassRoom();

	void addClass();

	void addtuition(int userId, int type, int maxAmount);

	// 학사정보

	List<Notice> viewNotice();

	void viewAcademicSchedule();

	// 단과대학 보기
	List<College> viewAllCollege();

	List<Department> viewAllmajor();

	// 등록 추가하기
	void addCollege(String name);

	// 등록 삭제하기
	void deleteCollege(String name);

	void addDept(int collegeId, String deptname);

	void updateDept(int deptId, String deptname);

	void deleteDept(String deptName);

	void addRoom(String roomId, int collegeId);

	List<Room> viwAllRoom();

	void deleteRoom(String roomId);
	
	List<Subject> viewAllClass();
}
