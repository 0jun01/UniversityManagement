package com.uni.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uni.system.repository.interfaces.NoticeRepository;
import com.uni.system.repository.interfaces.ScheduleRepository;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.NoticeList;
import com.uni.system.repository.model.Schedule;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.NoticeRepositoryImpl;
import com.uni.system.service.ScheduleRepositoryImpl;
import com.uni.system.service.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;
	NoticeRepository noticeRepository;
	ScheduleRepository scheduleRepository;

	public UserController() {
		userRepository = new UserRepositoryImpl();
		noticeRepository = new NoticeRepositoryImpl();
		scheduleRepository = new ScheduleRepositoryImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("DOGET PathInfo : " + action);
		switch (action) {
		case "/notice":
			request.getRequestDispatcher("/WEB-INF/six/user/notice.jsp").forward(request, response);
			break;
		case "/professor":
			request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);
			break;
		case "/logout":
			handleLogout(request, response);
			break;
		case "/home":
			showHomepage(request,response);
	
			break;
		case "/employee":
			request.getRequestDispatcher("/WEB-INF/views/user/employeeInfo.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	private void showHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NoticeList> noticeList = new ArrayList<NoticeList>();
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		
		
		scheduleList = scheduleRepository.selectAllscheduleTable();
		noticeList = noticeRepository.selectAllTable();
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("scheduleList", scheduleList);
		
		request.getRequestDispatcher("/WEB-INF/views/user/home.jsp").forward(request, response);
		
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
			break;
		}
	}

	private void handleSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("handleSignIn 호출 확인");
		// index.jsp 에서 입력한 아이디, 비밀번호 값을 userId, password 라는 곳에 담기.
		int userId = Integer.parseInt(request.getParameter("username")); // 23000001
		System.out.println(userId);
		String password = request.getParameter("password"); // 123123

		Cookie cookie = new Cookie("id", String.valueOf(userId));
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		
		
		
		// userRepository의 getUserInfoById(유저 정보 끌고 오기)를 사용하여 principal 이라는 곳에 담기.
		UserDTO principal = userRepository.getUserInfoById(userId);
		HttpSession session = request.getSession();

		// 입력한 값(userId, password)이 dto 값과 일치하는지 확인)
		if (userId == principal.getId() && password.equals(principal.getPassword())) {
			System.out.println("Login Success : " + principal);
			session.setAttribute("principal", principal); // header.jsp, 각종 info 에 끌고 오기 위해 속성 설정해주기.
			response.sendRedirect(request.getContextPath() + "/user/home");
		} else if(userId != principal.getId()){
		}

	}
}
