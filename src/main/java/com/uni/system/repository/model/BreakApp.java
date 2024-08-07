package com.uni.system.repository.model;

import java.sql.Date;

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
public class BreakApp {
	
	private int id;
	private int studentId;
	private int studentGrade;
	private int fromYear;
	private int fromSemester;
	private int toYear;
	private int toSemester;
	private String type; // 휴학 구분
	private Date appDate;
	private String status;
	// dev1 TEST
}
