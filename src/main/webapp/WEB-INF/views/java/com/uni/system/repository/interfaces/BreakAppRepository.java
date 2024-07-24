package com.uni.system.repository.interfaces;

import java.util.List;

import com.uni.system.repository.model.BreakApp;

public interface BreakAppRepository {
	
	void addBreak(int studentId, int grade, int fromYear, int fromSemester, int toYear, int toSemester, String type);
	BreakApp showBreakList(int userId);
	BreakApp checkDuplicate(int userId);
	
}
