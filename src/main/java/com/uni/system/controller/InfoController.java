package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.StudentRepository;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.User;
import com.uni.system.service.StudentRepositoryImpl;
@WebServlet("/info/*")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentRepository studentRepository;
	
	public InfoController() {	
		studentRepository = new StudentRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String action = request.getPathInfo();
		switch (action) {
		case "/student":
			System.out.println("Student");
			showMyInfo(request, response);
			break;

		case "/professor":
			request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
		
		case "/employee":
			request.getRequestDispatcher("/WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
		
	}

	private void showMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		
		if(principal == null) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
		}
		Student studentInfo = studentRepository.viewMyInfo(principal.getStudentId());
		request.setAttribute("studentInfo", studentInfo);
		
		request.getRequestDispatcher("/WEB-INF/views/user/studentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
