package com.uni.system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/tuition/*")
public class TuitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TuitionController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("tuition controller");
		switch (action) {
		case "/list":
			request.getRequestDispatcher("/WEB-INF/views/tuition/tuitionList.jsp").forward(request, response);
			break;

		case "/payment":
			request.getRequestDispatcher("/WEB-INF/views/tuition/tuitionPaymentNotice.jsp").forward(request, response);
			break;

		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
