package com.uni.system.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Subject {
	
	private int id;
	private String name; // 강의명
	private int professorId; // 교수 id
	private String roomId; // 방 번호
	private int deptId; // 과 번호
	private String type; // 전공/교양
	private int subYear; // 개설년도
	private int semester; // 학기
	private String subDay; // 요일
	private int startTime; // 개강 일
	private int endTime; // 종강 일
	private int grades; // 학점
	private int capacity; // 인원수
	private int numOfStudent; // 수강인원수 

}
