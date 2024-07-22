package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.Evaluation;
import com.uni.system.repository.model.Notice;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.Subject;

public interface ProfessorRepository {
	
	// MY 페이지
	void viewMyInfo(); // 내 정보 보기
	void changePassword(); // 비밀번호 변경
	
	// 수업
	List<Subject> viewAllSubject(); // 전체 강의 조회
	List<Subject> viewSubjectById(int id); // 내 강의 조회 (파라미터 설계, ID == 교수 ID)
	List<Evaluation> viewEvaluationById(int id); // 내 강의 평가 (교수 ID)
	
	// 학사정보
	List<Notice> viewNotice(); // 공지사항
	List<Schedule> viewAcademicSchedule(); // 학사일정
	void addAcademicSchedule(); // 학사일정 등록
	
	
}
