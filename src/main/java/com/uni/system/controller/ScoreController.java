package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/score/*")
public class ScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScoreController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/thisSemester":
			handleThisSemester(request, response);
			break;
		case "/bySemester":
			handleBySemester(request, response);
			break;
		case "/cumulative":
			handleCumulative(request, response);
			break;
		default:
			break;
		}
	}

	private void handleCumulative(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/six/score/cumulativeScore.jsp").forward(request, response);
	}

	private void handleBySemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/six/score/bySemesterScore.jsp").forward(request, response);
	}

	private void handleThisSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/six/score/thisSemesterScore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
