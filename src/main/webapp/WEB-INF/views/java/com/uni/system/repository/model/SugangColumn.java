package com.uni.system.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SugangColumn {
	String collegeName;
	String deptName;
	int subjectId;
	String type;
	String subjectName;
	String professorName;
	int grades;
	String subDay;
	int startTime;
	int endTime;
	String roomId;
	int numOfStudent;
	int capacity;
}
