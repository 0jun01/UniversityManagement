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
public class Schedule {
	
	int id;
	int staffId;
	Date startDay;
	Date endDay;
	String information;
}
