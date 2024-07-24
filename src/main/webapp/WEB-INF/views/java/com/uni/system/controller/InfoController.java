package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.interfaces.StudentRepository;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.model.Staff;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.User;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.StaffRepositoryImpl;
import com.uni.system.service.StudentRepositoryImpl;
import com.uni.system.service.UserRepositoryImpl;

@WebServlet("/info/*")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;
	StudentRepository studentRepository;
	StaffRepository staffRepository;

	public InfoController() {
	}
	
	@Override
	public void init() throws ServletException {
		studentRepository = new StudentRepositoryImpl();
		staffRepository = new StaffRepositoryImpl();
		userRepository = new UserRepositoryImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		switch (action) {
		case "/student":
			System.out.println("Student");
			showStudentInfo(request, response);
			break;
		case "/studentPassword":
			request.getRequestDispatcher("/WEB-INF/views/user/studentChangePassword.jsp").forward(request, response);
			break;
		case "/staff":
			System.out.println("Staff");
			showStaffInfo(request, response);
			break;
		case "/staffPassword":
			System.out.println("staffPassowrd");
			request.getRequestDispatcher("/WEB-INF/views/user/staffChangePassword.jsp").forward(request, response);
		default:
			break;
		}

	}

	private void showStaffInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		
		if(dto.getId() == 0) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
			return;
		}
		Staff staffInfo = staffRepository.viewMyInfo(dto.getId());
		session.setAttribute("staffInfo", staffInfo);
		
		request.getRequestDispatcher("/WEB-INF/views/user/staffInfo.jsp").forward(request, response);
	}

	private void showStudentInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		System.out.println(dto.getId());
		if (dto.getId() == 0) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
			return;
		}
		Student studentInfo = studentRepository.viewMyInfo(dto.getId()); // student 반
		System.out.println("Student Infomation : " + studentInfo);
		session.setAttribute("studentInfo", studentInfo);

		request.getRequestDispatcher("/WEB-INF/views/user/studentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getPathInfo();
		switch (action) {
		
		case "/studentPassword" :
			changePassword(request, response);
			break;
		case "/staffPassword" :
			changePassword(request, response);
			break;
		default:
			break;
		}
	}


	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		String currentPassword = request.getParameter("current_password");
		String changePassword = request.getParameter("change_password");
		System.out.println("Current Password : " + dto.getPassword());
		System.out.println("Changed Password : " + changePassword);
		
		if (dto.getId() != 0 && currentPassword == dto.getPassword()) {
			userRepository.changePassword(changePassword, dto.getId());
			response.sendRedirect(request.getContextPath() + "/user/home");
		
		} else if (dto.getUserRole().equals("student") && currentPassword != dto.getPassword()){
			response.sendRedirect(request.getContextPath() + "/info/student?error");
		} else if (dto.getUserRole().equals("staff") && currentPassword != dto.getPassword()) {
			response.sendRedirect(request.getContextPath() + "/info/staff");
		} else if (dto.getUserRole().equals("professor") && currentPassword != dto.getPassword())
			response.sendRedirect(request.getContextPath() + "/info/professor");
	}

}
