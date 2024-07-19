package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/info/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getContextPath();
		
		switch (action) {
		case "/student":
			request.getRequestDispatcher("WEB-INF/views/user/studentInfo.jsp").forward(request, response);
			break;

		case "/professor":
			request.getRequestDispatcher("WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
		
		case "/employee":
			request.getRequestDispatcher("WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
