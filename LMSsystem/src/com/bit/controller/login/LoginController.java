package com.bit.controller.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.model.dao.EmployeeDao;
import com.bit.model.dao.StudentDao;
import com.bit.model.dto.EmployeeDto;
import com.bit.model.dto.StudentDto;

@WebServlet("/login.bit")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/xml;charset=utf-8");
		String id = req.getParameter("id"); // ���̵�
		String password = req.getParameter("password"); // ��й�ȣ
		
		StudentDao stuDao = null; // �л� ���̺� �����ϴ� �������� Ȯ���ϱ� ���� Ŭ���� ����
		StudentDto stuBean = null;
		
		EmployeeDao empDao = null; // ���� ���̺� �����ϴ� �������� Ȯ���ϱ� ���� Ŭ���� ����
		EmployeeDto empBean = null;
		
		try {
			stuDao = new StudentDao();
			stuBean = stuDao.login(id, password); // �л� ���̺� �α��� Ȯ��
			
			if(stuBean == null) {
				empDao = new EmployeeDao();
				empBean = empDao.login(id, password); // ���� ���̺� �α��� Ȯ��
			}
			
			if(stuBean == null && empBean == null) {
				System.out.println("�α��� ����");
				try{
					resp.getWriter().write("<login><fail>loginFail</fail></login>");
					return;
				} catch (IOException e) {
	                e.printStackTrace();
	            }
			} else {	
				HttpSession session = req.getSession();
				session.setAttribute("stuBean", stuBean);
				session.setAttribute("empBean", empBean);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
