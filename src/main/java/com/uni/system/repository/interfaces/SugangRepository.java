package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.PreStuSub;
import com.uni.system.repository.model.SugangColumn;
import com.uni.system.repository.model.SugangDTO;
import com.uni.system.repository.model.SugangPreAppList;

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
	
	// 선택된 예비수강 목록 뽑기
	List<SugangPreAppList> viewSelectedPreAdd(int subjectId);
	
	// 수강신청 페이지에서 예비수강을 신청하면 예비수강 테이블 바로밑에 나오게 하는 메소드
	List<SugangPreAppList> viewSelectedAdd(int studentId);
	
	// 사전수강 신청 목록에서 자기 예비 수강신청 했던 목록 취소 버튼으로 변환 하기위해 신청했던 목록 찾기
	int protectDuplicatedPreAppPrinciapl(int principalId);
	int protectDuplicatedPreAppHaksuNum(int haksuNum);
	List<PreStuSub> duplicateCheck();
	
	
	// subjectId 삭제
	void deletePreAdd(int haksuNum);
	
	// 수강신청 페이지에서 신청완료한거 취소하는 메소드
	void deleteAdd(int haksuNum);
	
	// 예비 수강 목록 추가하기 (studentId, subjectId)
	void addSelectedPreAdd(int principalId ,int subjectId);
	
	// 찐 수강신청목록에 추가하기 (student_id, subject_id, grade)
	void addSugangList(int principalId, int subjectId);
	
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
	
	// 찐수강 신청 학점 계산 
	int sumGrade(int principal);
	
	// 예비 수강 리스트 페이지 학점 계산
	int sumPreGrade(int principal);
	
	// 예비신청하면 신청한 인원수 늘리기 
	void plusPreNumOfStudent(int numOfStudent, int haksuNum);
	
	// 예비신청 취소하면 신청한 인원수 줄이기
	void minusPreNumOfStudent(int haksuNum, int numOfStudent);
	
	// 어쩔 수 없는 스튜던트 인포 얻기
	int getDeptId(int principal);
}
