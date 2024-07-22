package com.uni.system.repository.model;

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
public class Question {
	int id;
	String question1;
	String question2;
	String question3;
	String question4;
	String question5;
	String question6;
	String question7;
	String sugContent;
}
