package com.uni.system.controller;

import java.io.IOException;

import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;

	public UserController() {
		userRepository = new UserRepositoryImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("DOGET PathInfo : " + action);
		switch (action) {

		case "/professor":
			request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
		case "/logout":
			handleLogout(request, response);
			break;
		case "/home":
			request.getRequestDispatcher("/WEB-INF/views/user/home.jsp").forward(request, response);
			break;
		case "/employee":
			request.getRequestDispatcher("/WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
			
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect(request.getContextPath() + "/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		System.out.println("action : " + action);

		switch (action) {
		case "/signIn":
			handleSignIn(request, response);
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void handleSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("handleSignIn 호출 확인");
		// index.jsp 에서 입력한 아이디, 비밀번호 값을 userId, password 라는 곳에 담기.
		int userId = Integer.parseInt(request.getParameter("username")); // 23000001
		System.out.println(userId);
		String password = request.getParameter("password"); // 123123

		// userRepository의 getUserInfoById(유저 정보 끌고 오기)를 사용하여 principal 이라는 곳에 담기.
		UserDTO principal = userRepository.getUserInfoById(userId);
		HttpSession session = request.getSession();

		// 입력한 값(userId, password)이 dto 값과 일치하는지 확인)
		if (userId == principal.getId() && password.equals(principal.getPassword())) {
			System.out.println("Login Success : " + principal);
			session.setAttribute("principal", principal); // header.jsp, 각종 info 에 끌고 오기 위해 속성 설정해주기.
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

}
