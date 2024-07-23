package com.uni.system.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectLectureList {
	
	int subYear;
	int semester;
	String collegeName;
	String departmentName;
	int haksuNum;
	String type;
	String lectureName;
	String professorName;
	int grades;
	int numOfStudent;
	int capacity;
}
