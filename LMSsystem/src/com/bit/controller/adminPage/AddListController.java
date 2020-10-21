package com.bit.controller.adminPage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.model.dao.EmployeeDao;


@WebServlet("/admin/addlist.bit")
public class AddListController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../addlist.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		int manageClass = Integer.parseInt(request.getParameter("manageClass"));
		int level = Integer.parseInt(request.getParameter("level"));
		
		EmployeeDao employeeDao;
		try {
			employeeDao = new EmployeeDao();
			int result=employeeDao.adminInsert(userId, password, name, contact, email, department, manageClass, level);
			if(result>0){
				response.sendRedirect("alist.bit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}