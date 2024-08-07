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

public class Student {
	private int id;
	private String name;
	private Date birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private int deptId;
	private int grade;
	private int semester;
	private Date entranceDate;
	private Date graduationDate;
	private String college;
	private String department;
	

}
