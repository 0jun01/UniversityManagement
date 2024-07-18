package com.uni.system.model;

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
public class NoticeFile {
	
	private int noticeId;
	private String originFilename;
	private String uuidFilename;
	
}
