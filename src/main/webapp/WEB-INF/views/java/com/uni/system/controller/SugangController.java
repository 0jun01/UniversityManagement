package com.uni.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SugangRepository;
import com.uni.system.repository.model.SubjectLectureList;
import com.uni.system.repository.model.SugangColumn;
import com.uni.system.repository.model.SugangDTO;
import com.uni.system.service.SugangRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sugang/*")
public class SugangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SugangRepository sugangRepository;
	
	@Override
	public void init() throws ServletException {
		sugangRepository = new SugangRepositoryImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/subjectList":
			getChecks(request,response);
			break;
		case "/filter":
			viewSlectedLecture(request,response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void viewSlectedLecture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SugangColumn> sugangColumnList = new ArrayList<SugangColumn>();
		
		String type = request.getParameter("type");
		String deptId = request.getParameter("deptId");
		String subName = request.getParameter("subName");
		
		int totalBoards = 0;
		
		viewLists(request, response);
		
		// 강의구분, 개설학과가 전체이고 강의명이 비어있을 경우
		if(type.equals("ALL") && deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.viewSugangValues();
			totalBoards = sugangRepository.getAllCount();
			
		// 강의구분만 선택 했을 시
		} else if(!type.equals("ALL") && deptId.equals("ALL") && subName.isEmpty()) {
			System.out.println("강의구분만 선택 했을 시");
			sugangColumnList = sugangRepository.selectType(type);
			totalBoards = sugangRepository.getSelectedTypeCount(type);
			
		// 개설학과만 선택 했을 시
		} else if(type.equals("ALL") && !deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectDept(deptId);
			totalBoards = sugangRepository.getSelectedDeptId(deptId);
			
		// 강의명만 선택했을 시	
		} else if(type.equals("ALL") && deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectLectureName(subName);
			totalBoards = sugangRepository.getSelectedLectureName(subName);
			
		// 강의구분 선택하고 개설학과 선택했을 경우
		} else if(!type.equals("ALL") && !deptId.equals("ALL") && subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectTypeAndDept(type, deptId);
			totalBoards = sugangRepository.getSelectedTypeAndDept(type, deptId);
			
		// 개설학과와 강의명 선택했을 경우	
		} else if (type.equals("ALL") && !deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectDeptAndLectureName(deptId, subName);
			totalBoards = sugangRepository.getSelectedDeptAndLectureNameCount(deptId, subName);
			
		// 강의구분 선택하고 강의명 선택했을 경우
		} else if (!type.equals("ALL") && deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectTypeAndLectureName(type, subName);
			totalBoards = sugangRepository.getSelectedTypeAndLectureNameCount(type, subName);
			
		// 모든 필터를 선택 했을 경우
		} else if(!type.equals("ALL") && !deptId.equals("ALL") && !subName.isEmpty()) {
			sugangColumnList = sugangRepository.selectAllFilter(type, deptId, subName);
			totalBoards = sugangRepository.getSelectedAll(type, deptId, subName);
		}
		
		request.setAttribute("sugangColumnList", sugangColumnList);
		request.setAttribute("totalBoards", totalBoards);
		request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
		
	}
	private void getChecks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이징 처리
		int page = 1;
		int pageSize = 20;
		try {
			String pageStr = request.getParameter("page");
			if (pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page - 1) * pageSize;
		
		int totalBoards = sugangRepository.getAllCount();
		int totalPages = (int) Math.ceil((double) totalBoards / (double) pageSize);
		
		List<SugangColumn> sugangColumnList = sugangRepository.viewSugangColumn(pageSize, offset);
		
		viewLists(request, response);
		request.setAttribute("totalBoards", totalBoards);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("sugangColumnList", sugangColumnList);
		request.getRequestDispatcher("/WEB-INF/views/sugang/subjectList.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void viewLists(HttpServletRequest request, HttpServletResponse response) {
		List<SugangDTO> type= sugangRepository.getSugangType();
		List<SugangDTO> sugangDeptName = sugangRepository.getSugangDeptName();
		List<SugangDTO> sugangLectureName = sugangRepository.getSugangLectureName();
		
		request.setAttribute("sugangType", type);
		request.setAttribute("sugangDeptName", sugangDeptName);
		request.setAttribute("sugangLectureName", sugangLectureName);
	}

}
