package com.uni.system.repository.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Staff {
	
	int id;
	String name;
	Date birthDate;
	String gender;
	String address;
	String tel;
	String email;
	Date hireDate;
}
