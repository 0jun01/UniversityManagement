package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.SubjectRepository;
import com.uni.system.repository.model.SubjectLectureList;
import com.uni.system.service.SubjectRepositoryImpl;

@WebServlet("/subject/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectRepository subjectRepository;

	@Override
	public void init() throws ServletException {
		subjectRepository = new SubjectRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("GET action: " + action);
		switch (action) {
		case "/subject":
			handleSubject(request, response);
			break;
		case "/list":
			handleList(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handleSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		int totalBoards = subjectRepository.getAllLectureCount();
		int totalPages = (int) Math.ceil((double) totalBoards / (double) pageSize);
		List<SubjectLectureList> subjectList = subjectRepository.selectAllTable(pageSize, offset);
		
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("totalBoards", totalBoards);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		request.getRequestDispatcher("/WEB-INF/views/user/subject.jsp").forward(request, response);
	}

	private void handleList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String deptName = request.getParameter("dept_id");
		int deptId = Integer.parseInt(deptName);
		String lectureName = request.getParameter("lecture_name");
		
		int totalBoards = 0;
		List<SubjectLectureList> subjectList = subjectRepository.selectByYearAndSemester(Integer.parseInt(year),
				Integer.parseInt(semester));
		request.setAttribute("subjectList", subjectList);

		if (year != null && semester != null && deptId == -1 && lectureName.isEmpty()) {
			subjectList = subjectRepository.selectByYearAndSemester(Integer.parseInt(year), Integer.parseInt(semester));
			System.out.println("개설학과와 강의명을 선택 안했을경우 : " + subjectList);
			totalBoards = subjectRepository.getByYearAndSemesterCount(Integer.parseInt(year), Integer.parseInt(semester));
			
		} else if (year != null && semester != null && deptId != -1 && lectureName.isEmpty()) {
			subjectList = subjectRepository.selectBySemesterAndDeptAndName(Integer.parseInt(year),
					Integer.parseInt(semester), deptId);
			System.out.println("강의명을 선택 안했을경우 :  " + subjectList);
			totalBoards = subjectRepository.getBySemesterAndDeptAndNameCount(Integer.parseInt(year),
					Integer.parseInt(semester), deptId);

		} else if (year != null && semester != null && deptId != -1 && !lectureName.isEmpty()) {
			subjectList = subjectRepository.selectBySemesterAndDeptAndNameAndTpye(Integer.parseInt(year),
					Integer.parseInt(semester), deptId, lectureName);
			System.out.println("다 선택했을 경우 : " + subjectList);
			totalBoards = subjectRepository.getBySemesterAndDeptAndNameAndTypeCount(Integer.parseInt(year),
					Integer.parseInt(semester), deptId, lectureName);

		} else if (year != null && semester != null && deptId == -1 && !lectureName.isEmpty()) {
			subjectList = subjectRepository.selectByYearAndSemesterAndType(Integer.parseInt(year),
					Integer.parseInt(semester), lectureName);
			System.out.println("개설학과만 선택 안했을 경우 : " + subjectList);
			totalBoards = subjectRepository.getByYearAndSemesterAndTypeCount(Integer.parseInt(year),
					Integer.parseInt(semester), lectureName);
		}
		
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("totalBoards", totalBoards);
		request.getRequestDispatcher("/WEB-INF/views/user/subject.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
