package com.bit.dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dept.model.Emp04Dto;

@WebServlet("/detail.bit")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("login");
		if(obj != null){
			Emp04Dto bean = (Emp04Dto)obj;
			if(bean.getLvl() > 1){
				req.getRequestDispatcher("detail.jsp").forward(req, resp);							
			} else{ // 특정 조건을 만족하지 못하는 계정인 경우,		
				req.getRequestDispatcher("error.jsp").forward(req, resp);							
			}
		} else { // obj == null
			resp.sendRedirect("login.bit");
		}
		
	}
}
