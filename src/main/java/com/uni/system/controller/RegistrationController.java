package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.model.College;
import com.uni.system.repository.model.Department;
import com.uni.system.repository.model.Room;
import com.uni.system.repository.model.Subject;
import com.uni.system.service.StaffRepositoryImpl;

@WebServlet("/admin/*")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StaffRepository staffRepository;

	@Override
	public void init() throws ServletException {
		staffRepository = new StaffRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("get PATHINO" + action);
		switch (action) {
		case "/college":
			viewCollege(request, response);
			processCRUD(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/registration.jsp").forward(request, response);
			break;
		case "/collegeDelete":
			viewCollege(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeDelete.jsp").forward(request, response);
			break;
		case "/collegeDeletion":
			deleteCollege(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeDelete.jsp").forward(request, response);
			break;
		case "/deptRegistration":
			viewCollege(request, response);
			viewDept(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/deptRegisteration.jsp").forward(request, response);
			break;
		case "/collegeUpdate":
			viewDept(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeUpdate.jsp").forward(request, response);
			break;
		case "/majorFilter":
			viewCollege(request, response);
			viewDept(request, response);
			handleFilter(request, response);
			break;
		case "/deptDelete":
			viewDept(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/deptDelete.jsp").forward(request, response);
			break;
		case "/departmentDelete":
			viewDept(request, response);
			deleteDept(request, response);
			request.getRequestDispatcher("/WEB-INF/views/user/deptDelete.jsp").forward(request, response);
			break;
		case "/room":
			viewAllRoom(request,response);
			request.getRequestDispatcher("/WEB-INF/views/user/room.jsp").forward(request, response);
			break;
		case "/roomDelete":
			viewAllRoom(request,response);
			request.getRequestDispatcher("/WEB-INF/views/user/roomDelete.jsp").forward(request, response);
			break;
		case "/roomProcess":
			viewAllRoom(request,response);
			deleteRoom(request,response);
			request.getRequestDispatcher("/WEB-INF/views/user/roomDelete.jsp").forward(request, response);
			break;
		case "/lecture":
			viewAllSubject(request,response);
			request.getRequestDispatcher("/WEB-INF/views/user/lecture.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}

	private void viewAllSubject(HttpServletRequest request, HttpServletResponse response) {
		List<Subject> subjectList= staffRepository.viewAllClass();
		System.out.println(subjectList);
		request.setAttribute("subjectList", subjectList);
	}

	private void deleteRoom(HttpServletRequest request, HttpServletResponse response) {
		String roomId = request.getParameter("roomId");
		staffRepository.deleteRoom(roomId);
	}

	private void viewAllRoom(HttpServletRequest request, HttpServletResponse response) {
		List<Room> roomList = staffRepository.viwAllRoom();
		request.setAttribute("roomList", roomList);
	}

	private void deleteDept(HttpServletRequest request, HttpServletResponse response) {
		String deptName = request.getParameter("collegeName");
		staffRepository.deleteDept(deptName);
	}

	private void addDept(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptIdStr = request.getParameter("deptId");
		String subName = request.getParameter("subName");
		int deptId = Integer.parseInt(deptIdStr);

		if (deptId != -1) {
			System.out.println("들어옴? " + deptId + subName);
			staffRepository.addDept(deptId, subName);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeUpdate.jsp").forward(request, response);
		} else {
			String message = "입력란을 선택하세요";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeUpdate.jsp").forward(request, response);
		}
	}
	private void updateDept(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptIdStr = request.getParameter("deptId");
		String subName = request.getParameter("subName");
		int deptId = Integer.parseInt(deptIdStr);
		
		if (deptId != -1) {
			System.out.println("들어옴? " + deptId + subName);
			staffRepository.updateDept(deptId, subName);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeUpdate.jsp").forward(request, response);
		} else {
			String message = "입력란을 선택하세요";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/views/user/collegeUpdate.jsp").forward(request, response);
		}
	}

	private void handleFilter(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String deptIdStr = request.getParameter("deptId");
		String subName = request.getParameter("subName");
		int deptId = Integer.parseInt(deptIdStr);

		if (deptId != -1) {
			staffRepository.addDept(deptId, subName);
			request.getRequestDispatcher("/WEB-INF/views/user/deptRegisteration.jsp").forward(request, response);
		} else {
			String message = "개설학과를 입력하세요";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/views/user/deptRegisteration.jsp").forward(request, response);
		}
	}

	private void viewDept(HttpServletRequest request, HttpServletResponse response) {
		List<Department> dept = staffRepository.viewAllmajor();
		request.setAttribute("dept", dept);
	}

	private void deleteCollege(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String collegeName = request.getParameter("collegeName");
		staffRepository.deleteCollege(collegeName);

	}

	private void processCRUD(HttpServletRequest request, HttpServletResponse response) {
		String crud = request.getParameter("crud");
		String crudType = "";
		if ("insert".equals(crud)) {
			crudType = "<form action=\"" + request.getContextPath() + "/admin/college\" method=\"POST\">"
					+ "<input type=\"text\" name=\"college_name\" placeholder=\"단과대학을 입력해주세요\">"
					+ "<button type=\"submit\">입력</button>" + "</form>";
			request.setAttribute("crudType", crudType);
		} else {
			request.setAttribute("crudType", "");
		}

	}

	private void viewCollege(HttpServletRequest request, HttpServletResponse response) {
		List<College> collegeList = staffRepository.viewAllCollege();
		request.setAttribute("collegeList", collegeList);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/college":
			addCollege(request, response);
			response.sendRedirect(request.getContextPath() + "/admin/college?crud=insert");
			break;
		case "/updateFilter":
			viewDept(request, response);
			updateDept(request, response);
			break;
		case "/addFilter":
			viewDept(request, response);
			addDept(request, response);
			break;
		case "/roomRegister":
			viewAllRoom(request,response);
			addRoom(request,response);
			request.getRequestDispatcher("/WEB-INF/views/user/room.jsp").forward(request, response);
			break;

		default:
			break;
		}
	}

	private void addRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomId = request.getParameter("roomId");
		String collegeIdStr = request.getParameter("collegeId");
		int collegeId = Integer.parseInt(collegeIdStr);
		staffRepository.addRoom(roomId, collegeId);
	}

	private void addCollege(HttpServletRequest request, HttpServletResponse response) {
		String collegeName = request.getParameter("college_name");
		staffRepository.addCollege(collegeName);
	}

}
