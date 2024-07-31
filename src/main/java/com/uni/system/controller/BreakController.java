package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.uni.system.repository.interfaces.BreakAppRepository;
import com.uni.system.repository.model.BreakApp;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.BreakAppRepositoryImpl;

@WebServlet("/break/*")
public class BreakController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BreakAppRepository breakAppRepository;

	public BreakController() {
		breakAppRepository = new BreakAppRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/send":
			request.getRequestDispatcher("/WEB-INF/views/break/breakSend.jsp").forward(request, response);
			break;

		case "/list":
			showAllBreak(request, response);
			
			break;

		default:
			break;
		}

	}

	private void showAllBreak(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		
		List<BreakApp> breakApp = breakAppRepository.getBreakList(dto.getId());
		request.setAttribute("breakAppList", breakApp);
		
		request.getRequestDispatcher("/WEB-INF/views/break/breakList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student studentInfo = (Student) session.getAttribute("studentInfo");
		session.setAttribute("userId", studentInfo.getId());

		String action = request.getPathInfo();

		switch (action) {
		case "/send":
			sendBreak(request, response);
			break;

		default:
			break;
		}
	}

	private void sendBreak(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 휴학 정보 뽑기
		String breakKinds = request.getParameter("fav_language");
		System.out.println("휴학 사유 구분 " + breakKinds);

		int fromSemester = Integer.parseInt(request.getParameter("fromSemester"));
		System.out.println("몇 학기부터? : " + fromSemester);

		int toYear = Integer.parseInt(request.getParameter("toYear"));
		System.out.println("몇 년도까지 ? : " + toYear);

		int toSemster = Integer.parseInt(request.getParameter("toSemester"));
		System.out.println("몇 학기까지 ? : " + toSemster);

		// session 저장
		HttpSession session = request.getSession();
		Student studentInfo = (Student) session.getAttribute("studentInfo");
		System.out.println("StudentInfo : " + studentInfo.getId());
		BreakApp breakApp = breakAppRepository.checkDuplicate(studentInfo.getId());
		
		if (breakApp != null) { // 이미 썼다. 그러면 리턴
			response.sendRedirect(request.getContextPath() + "/break/send?message=error");
			return;
		} else { // 쓴 적이 없다. null 이다.
				breakAppRepository.addBreak(studentInfo.getId(), studentInfo.getGrade(), 2024, fromSemester, toYear, toSemster, breakKinds);
				session.setAttribute("breakedStudent", studentInfo.getId());
				response.sendRedirect(request.getContextPath() + "/info/student");
				return;
			}
		}


	

}
