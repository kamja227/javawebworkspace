package com.bit.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dept.model.Dept04Dao;

@WebServlet("/dept/detail.bit")
public class DetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("idx"));
		try {
			Dept04Dao dao = new Dept04Dao();
			request.setAttribute("bean", dao.selectOne(deptno));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("../detail.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int deptno = Integer.parseInt(request.getParameter("idx"));
		String dname = request.getParameter("dname").trim();
		String loc = request.getParameter("loc").trim();
		try {
			Dept04Dao dao = new Dept04Dao();
			dao.updateOne(deptno, dname, loc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("list.bit");
	}

}
