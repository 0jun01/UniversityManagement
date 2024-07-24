package com.uni.system.repository.interfaces;

import java.util.List;
import com.uni.system.repository.model.*;

public interface StudentRepository {
	
	// MY 페이지
	Student viewMyInfo(int userid);      // 내 정보 보기
	void changePassword(String password, int userId); // 비밀번호 변경
	
	// 수업
	List<Subject> viewAllClass(); // 전체 강의 조회
	
	// 수강 신청
	void viewAllClassSchedule(); // 강의 시간표 조회
	void addBeforehandToDoCourse(); // 예비 수강 신청
	void addToDoCourse(); // 수강 신청
	void viewToDoCourse(); // 수강 신청 내역 조회
	
	// 성적
	void viewScore(); // 금학기 성적 조회
	void viewScoreBySemester(); // 학기별 성적 조회
	List<Grade> viewAllScore(); // 누계 성적
	
	// 학사정보
	List<Notice> viewNotice(); // 공지사항 
	void viewAcademicSchedule(); // 학사일정

}
