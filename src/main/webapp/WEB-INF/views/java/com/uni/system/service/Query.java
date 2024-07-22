package com.uni.system.service;

public class Query {
	
	// 학생 정보 보기 
	final String VIEW_STUDENT_INFO = " SELECT * FROM student_tb WHERE id = ? ";
	
	// 비밀번호 변경 
	final String CHANGE_PASSWORD = " UPDATE user_tb SET password = ? WHERE id = ? ";
	// 휴학 신청 
	//	static final String = " "; TODO - ADD Break
	
	// 휴학 신청 목록 보기 
	final String VIEW_ALL_BREAK = " SELECT * FROM break_tb WHERE student_id = ? ";
	
	// 등록금 내역 조회
	final String VIEW_ALL_TUITION = " SELECT * FROM tuition_tb WHERE student_id = ? ";
	
	// 등록금 납부 고지서
//	static final String 
	
	// 전체 강의 조회
	final String VIEW_ALL_CLASS = " SELECT * FROM subject_tb ";
	
	// 로그인 유저 아이디 비밀번호 확인
	final String SELECT_USER_BY_PASSWORD = " SELECT * FROM user_tb WHERE id = ? AND password = ? " ;
	
	final String GET_USER_ROLE = " SELECT user_role from user_tb where id = ? ";
}
