package com.uni.system.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Student;
import com.uni.system.service.StaffRepositoryImpl;
import com.uni.system.service.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/management/*")
public class ManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserRepository userRepository;
	StaffRepository staffRepository;
    public ManagementController() {
    	
    }
    
    @Override
    public void init() throws ServletException {
    	userRepository = new UserRepositoryImpl();
    	staffRepository = new StaffRepositoryImpl();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생 명단, 교수 명단, 학생 등록, 교수 등록, 직원 등록, 고지서 발송, 휴학 처리, 수강 신청 기간 설정
		String action = request.getPathInfo();
		switch (action) {
		case "/studentList":
			handleStudent(request, response);
			break;
		case "/professorList":
			handleProfessor(request, response);
			break;
		case "/addStudent":
			request.getRequestDispatcher("/WEB-INF/views/user/addStudent.jsp").forward(request, response);
			break;
		case "/addProfessor":
			request.getRequestDispatcher("/WEB-INF/views/user/addProfessor.jsp").forward(request, response);
			break;
		case "/addStaff":
			request.getRequestDispatcher("/WEB-INF/views/user/addStaff.jsp").forward(request, response);
			break;
		case "/sendTuition":
			request.getRequestDispatcher("/WEB-INF/views/user/sendTuition.jsp").forward(request, response);
			break;
		case "/breakList":
			request.getRequestDispatcher("/WEB-INF/views/user/breakList.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
		
	}

	private void handleProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int pageSize = 20;
		try {
			String pageStr = request.getParameter("page");
			if(pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page - 1) * pageSize;
		int totalBoards = staffRepository.getAllProfessorLectureCount();
		int totalPages = (int) Math.ceil((double) totalBoards / (double) pageSize);
		List<Professor> professorList = staffRepository.viewAllProfessor(pageSize, offset);
		
		request.setAttribute("professorList", professorList);
		request.setAttribute("totalBoards", totalBoards);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		request.getRequestDispatcher("/WEB-INF/views/user/professorList.jsp").forward(request, response);
		
	}

	private void handleStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int pageSize = 20;
		try {
			String pageStr = request.getParameter("page");
			if(pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
		} catch (Exception e) {
			page = 1;
		}
		int offset = (page - 1) * pageSize;
		int totalBoards = staffRepository.getAllStudentLectureCount();
		int totalPages = (int) Math.ceil((double) totalBoards / (double) pageSize);
		List<Student> studentList = staffRepository.viewAllStudent(pageSize, offset);
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("totalBoards", totalBoards);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
		request.getRequestDispatcher("/WEB-INF/views/user/studentList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/addStudent":
			addStudent(request, response);
			break;
		case "/addProfessor":
			addProfessor(request, response);
			break;
		case "/addStaff":
			addStaff(request, response);
			break;
		case "/sendTuition":
			sendTutition(request, response);
			break;
		default:
			break;
		}
		
	}

	private void sendTutition(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void addStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");

		// 생일 포맷팅 처리
		Date birthDate = Date.valueOf(birth);
		
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		staffRepository.addStaff(name, birthDate, gender, address, tel, email);
		
		request.getRequestDispatcher("/WEB-INF/views/user/addProfessor.jsp").forward(request, response);

	}

	private void addProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");

		// 생일 포맷팅 처리
		Date birthDate = Date.valueOf(birth);
		
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		
		staffRepository.addProfessor(name, birthDate, gender, address, tel, email, deptId);
		
		request.getRequestDispatcher("/WEB-INF/views/user/addProfessor.jsp").forward(request, response);
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birthDate");
		String entrance = request.getParameter("entranceDate");

		// 생일, 입학날짜 포맷팅 처리
		Date birthDate = Date.valueOf(birth);
		Date entranceDate = Date.valueOf(entrance);
		
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		
		staffRepository.addStudent(name, birthDate, gender, address, tel, email, deptId, entranceDate);
		
		request.getRequestDispatcher("/WEB-INF/views/user/addStudent.jsp").forward(request, response);
	}

}
