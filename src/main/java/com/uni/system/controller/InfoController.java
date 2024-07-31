package com.uni.system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.uni.system.repository.interfaces.ProfessorRepository;
import com.uni.system.repository.interfaces.StaffRepository;
import com.uni.system.repository.interfaces.StudentRepository;
import com.uni.system.repository.interfaces.UserRepository;
import com.uni.system.repository.interfaces.FindRepository;
import com.uni.system.repository.model.Professor;
import com.uni.system.repository.model.Staff;
import com.uni.system.repository.model.Student;
import com.uni.system.repository.model.UserDTO;
import com.uni.system.service.FindRepositoryImpl;
import com.uni.system.service.ProfessorRepositoryimpl;
import com.uni.system.service.StaffRepositoryImpl;
import com.uni.system.service.StudentRepositoryImpl;
import com.uni.system.service.UserRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/info/*")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository;
	StudentRepository studentRepository;
	StaffRepository staffRepository;
	ProfessorRepository professorRepository;
	FindRepository findRepository;

	public InfoController() {
	}

	@Override
	public void init() throws ServletException {
		studentRepository = new StudentRepositoryImpl();
		staffRepository = new StaffRepositoryImpl();
		userRepository = new UserRepositoryImpl();
		professorRepository = new ProfessorRepositoryimpl();
		findRepository = new FindRepositoryImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getPathInfo();
		switch (action) {
		case "/updatestudent":
			System.out.println("업데이트스튜던트");
			request.getRequestDispatcher("/WEB-INF/views/user/updatestudent.jsp").forward(request, response);
			break;
		case "/updatestaff":
			System.out.println("업데이트스태프");
			request.getRequestDispatcher("/WEB-INF/views/user/updatestaff.jsp").forward(request, response);
			break;
		case "/student":
			showStudentInfo(request, response);
			break;
		case "/studentPassword":
			request.getRequestDispatcher("/WEB-INF/views/user/studentChangePassword.jsp").forward(request, response);
			break;
		case "/staff":
			showStaffInfo(request, response);
			break;
		case "/staffPassword":
			request.getRequestDispatcher("/WEB-INF/views/user/staffChangePassword.jsp").forward(request, response);
			break;
		case "/professor":
			showProfessorInfo(request, response);
			break;
		case "/professorPassword":
			request.getRequestDispatcher("/WEB-INF/views/user/professorPassword.jsp").forward(request, response);
			break;
		case "/professorMy":
			request.getRequestDispatcher("/WEB-INF/views/user/professorMyInfo.jsp").forward(request, response);
			break;
		case "/changeStudentInfo":
			request.getRequestDispatcher("/WEB-INF/views/user/studentMyInfoUpdate.jsp").forward(request, response);
			break;
		case "/changeStaffInfo":
			request.getRequestDispatcher("/WEB-INF/views/user/staffMyInfoUpdate.jsp").forward(request, response);
			break;
		case "/changeProfessorInfo":
			request.getRequestDispatcher("/WEB-INF/views/user/professorMyInfoUpdate.jsp").forward(request, response);
			break;
		case "/findId":
			request.getRequestDispatcher("/WEB-INF/views/find/findId.jsp").forward(request, response);
			break;
		case "/findPassword":
			request.getRequestDispatcher("/WEB-INF/views/find/findPw.jsp").forward(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	private void updateStudentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		System.out.println("password : " + password);
		System.out.println("email : " + email);
		System.out.println("address : " + address);
		System.out.println("tel : " + tel);
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO) session.getAttribute("principal");
		String checkPassword = userRepository.checkPassword(principal.getId());
		System.out.println(" checkpassword : "   + checkPassword);
		System.out.println("아이디" + principal.getId());
		System.out.println(" principal.getUserRole() : "   + principal.getUserRole());
		
		if (password != null && password.equals(checkPassword)) {
			// 업데이트 실행
			if(email != null && address != null && tel != null) {
				userRepository.updateInfo(principal.getId(), address, tel, email, principal.getUserRole());
			}
		} else {
			
			
		}
		

	}
	
	private void showProfessorInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");

		if (dto.getId() == 0) {
			response.sendRedirect(request.getContextPath() + "/info?message=invalid");
			return;
		}
		Professor professor = professorRepository.viewMyInfo(dto.getId());
		session.setAttribute("professorInfo", professor);

		request.getRequestDispatcher("/WEB-INF/views/user/professorInfo.jsp").forward(request, response);

	}

	private void showStaffInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");

		if (dto.getId() == 0) {
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

		case "/studentPassword":
			changePassword(request, response);
			break;
		case "/updatestaff" :
			updateStudentInfo(request, response);
			response.sendRedirect(request.getContextPath() + "/info/staff");
			break;
		case "/staffPassword" :
			changePassword(request, response);
			break;
		case "/professorPassword":
			changePassword(request, response);
		case "/updatestudent":
			updateStudentInfo(request, response);
			response.sendRedirect(request.getContextPath() + "/info/student");
			break;
		case "/updateStudent":
			changeInfomartion(request, response);
			break;
		case "/updateStaff":
			changeInfomartion(request, response);
			break;
		case "/updateProfessor":
			changeInfomartion(request, response);
			break;
		case "/findId":
			findMyID(request, response);
			break;
		case "/findPw":
			findMyPW(request, response);
			break;
		default:
			break;
		}
	}

	private void findMyPW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserDTO dto = null;
		dto = findRepository.findMyPW(userId);
		request.setAttribute("findMyPw", dto);
		System.out.println(dto.getPassword());
		request.getRequestDispatcher("/WEB-INF/views/find/findPw.jsp").forward(request, response);
	}

	private void findMyID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		UserDTO dto = null;
		if(type.equals("student")) {
			dto = findRepository.findStudentID(userName, email);
			request.setAttribute("findMyId", dto);
			request.getRequestDispatcher("/WEB-INF/views/find/findId.jsp").forward(request, response);
			return;
		} else if(type.equals("staff")) {
			dto = findRepository.findStaffID(userName, email);
			request.setAttribute("findMyId", dto);
			request.getRequestDispatcher("/WEB-INF/views/find/findId.jsp").forward(request, response);
			return;
		} else if(type.equals("professor")) {
			dto = findRepository.findProfessor(userName, email);
			request.setAttribute("findMyId", dto);
			request.getRequestDispatcher("/WEB-INF/views/find/findId.jsp").forward(request, response);
			return;
		}
		
	}

	private void changeInfomartion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		
		String address = request.getParameter("address");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String email = request.getParameter("email");
		String checkPassword = request.getParameter("checkPassword");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userRole = request.getParameter("userRole");
		
		System.out.println("address : " + address);
		System.out.println("tel : " + tel);
		System.out.println("email : "  + email);
		System.out.println("checkPassword : " + checkPassword);
		System.out.println("Student ID : " + userId);
		
		if(userRole.equals("student") && checkPassword.equals(dto.getPassword())) {
			studentRepository.changeInfomation(address, tel, email, userId);
			response.sendRedirect(request.getContextPath() + "/info/student");
		} else if (userRole.equals("staff") && checkPassword.equals(dto.getPassword())) {
			staffRepository.changeInfomation(address, tel, email, userId);
			response.sendRedirect(request.getContextPath() + "/info/staff");
		} else if (userRole.equals("professor") && checkPassword.equals(dto.getPassword())) {
			professorRepository.changeInfomation(address, tel, email, userId);
			response.sendRedirect(request.getContextPath() + "/info/professor");
		} else if (!checkPassword.equals(dto.getPassword())){
				if(userRole.equals("student")) {
					response.sendRedirect(request.getContextPath() + "/info/student");
					alert(response);
					return;
				} else if (userRole.equals("staff")) {
					response.sendRedirect(request.getContextPath() + "/info/staff");
					alert(response);
					return;
				} else if (userRole.equals("professor")) {
					response.sendRedirect(request.getContextPath() + "/info/professor");
					alert(response);
					return;
				}
		  }
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("changedPassword Method 호출");
		HttpSession session = request.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("principal");
		String currentPassword = request.getParameter("current_password");
		String changePassword = request.getParameter("change_password");
		System.out.println("유저 아이디" + dto.getId());
		System.out.println("현재 입력한 비밀번호 : " + currentPassword);
		System.out.println("바꾸려고 하는 비밀번호 : " + changePassword);
		System.out.println("DB에 있는 비번 : " + dto.getPassword());

		if (dto.getId() != 0 && currentPassword.equals(dto.getPassword())) {
			userRepository.changePassword(changePassword, dto.getId());
			response.sendRedirect(request.getContextPath() + "/user/home");

		} else if (dto.getUserRole().equals("student") && currentPassword != dto.getPassword()) {
			response.sendRedirect(request.getContextPath() + "/info/student?error");
		} else if (dto.getUserRole().equals("staff") && currentPassword != dto.getPassword()) {
			response.sendRedirect(request.getContextPath() + "/info/staff?error");
		} else if (dto.getUserRole().equals("professor") && currentPassword != dto.getPassword())
			response.sendRedirect(request.getContextPath() + "/info/professor?error");
	}
	
	public static void alert(HttpServletResponse response) {
	    try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("<script>alert('"+"비밀번호가 잘못되었습니다."+"');</script>");
			writer.flush();
			writer.close();
	    } catch(Exception e) {
			e.printStackTrace();
	    }
	}

}
