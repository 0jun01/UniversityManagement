package com.uni.system.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Notice {
	
	private int id;
	private String category;
	private String title;
	private String content;
	private Timestamp createdTime;
	private int views;
	
}
