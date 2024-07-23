package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.SubjectLectureList;

public interface SubjectRepository {
		
	List<SubjectLectureList> selectByYearAndSemester(int year, int semester);
	
	// 연도-학기-개설학과-강의명 검색을 조건으로 한 강의 정보
	List<SubjectLectureList> selectBySemesterAndDeptAndName(int year, int semester, int deptId);
	
	// 연도-학기-강의명 검색을 조건으로 한 강의 정보
	List<SubjectLectureList> selectByYearAndSemesterAndType(int year, int semester, String lectureName);
	
	// syllabus 강의 이름
	// 연도-학기-강의구분-개설학과-강의명 검색을 조건으로 한 강의 정보
	List<SubjectLectureList> selectBySemesterAndDeptAndNameAndTpye(int year, int semester, int deptId, String lectureName);
	
	// 수업 페이지 접속 시 모든 강의 보이게 하기
	List<SubjectLectureList> selectAllTable(int pageSize, int offset);
	
	// 모든 강의 수 조회
	int getAllLectureCount(); 
	
	// 연도랑 학기만 선택시
	int getByYearAndSemesterCount(int year, int semester);
	
	// 연도-학기-개설학과-강의명 선택시
	int getBySemesterAndDeptAndNameCount(int year, int semester, int deptId); 
	
	int getByYearAndSemesterAndTypeCount(int year, int semester, String lectureName);
	
	// 모두 선택시
	int getBySemesterAndDeptAndNameAndTypeCount(int year, int semester, int deptId, String lectureName);  
	
	
	
}
