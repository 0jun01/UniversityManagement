package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.SugangColumn;
import com.uni.system.repository.model.SugangDTO;

public interface SugangRepository {
	
	// 수강 타입 얻기
	List<SugangDTO> getSugangType();
	
	// 학과 이름 얻기
	List<SugangDTO> getSugangDeptName();
	
	// 강의명 얻기
	List<SugangDTO> getSugangLectureName();
	
	// 수강목록들 얻기
	List<SugangColumn> viewSugangColumn(int pageSize, int offset);
	
	// 조회 쿼리
	List<SugangColumn> viewSugangValues();
	
	// 강의구분만 선택시
	List<SugangColumn> selectType(String type);
	
	// 개설학과만 선택했을시
	List<SugangColumn> selectDept(String departName);
	
	// 강의명만 선택했을시
	List<SugangColumn> selectLectureName(String lectureName);
	
	// 강의구분 선택하고 개설학과 선택했을시
	List<SugangColumn> selectTypeAndDept(String type, String deptName);
	
	// 개설학과와 강의명 선택 했을시
	List<SugangColumn> selectDeptAndLectureName(String deptName, String lectureName);
	
	// 강의구분 선택하고 강의명 선택 했을시
	List<SugangColumn> selectTypeAndLectureName(String type, String lectureName);
	
	// 다 선택 했을시
	List<SugangColumn> selectAllFilter(String type, String deptName, String lectureName);
	
	// 모든 조회될 목록들 카운트
	int getAllCount();
	
	// 강의구분만 조회 했을때의 카운트
	int getSelectedTypeCount(String type);
	
	// 개설학과만 선택했을 시 카운트
	int getSelectedDeptId(String deptId);
	
	// 강의명만 선택했을 시 카운트
	int getSelectedLectureName(String lectureName);
	
	// 강의구분 선택하고 개설학과 선택했을시 카운트
	int getSelectedTypeAndDept(String type, String deptId);
	
	// 개설학과와 강의명 선택 했을시
	int getSelectedDeptAndLectureNameCount(String deptId, String lectureName);
	
	// 강의구분 선택하고 강의명 선택 했을시
	int getSelectedTypeAndLectureNameCount(String type, String lectureName);
	
	// 다 선택 했을시
	int getSelectedAll(String type, String deptId, String lectureName);
}
