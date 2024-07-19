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

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;
	
	
	public UserController() {
		userRepository = new UserRepositoryImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("DOGET PathInfo : " + action);
		switch (action) {
		case "/signup":
			request.getRequestDispatcher("/WEB-INF/six/user/signup.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
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
		
		int userId = Integer.parseInt(request.getParameter("username")); // 23000001
		System.out.println(userId);
		String password = request.getParameter("password"); // 123123
		UserDTO principal = userRepository.getUserbyRole(userId);
		
		if(userId == principal.getId() && password.equals(principal.getPassword())) {
		
			request.setAttribute("principal", principal);
			response.sendRedirect(password);
		}

	}

}
