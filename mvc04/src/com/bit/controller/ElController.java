package com.bit.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.JavaBean;

@WebServlet("/el/ex02.bit")
public class ElController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaBean bean = new JavaBean();
		bean.setSu1(1234);
		bean.setSu2(3.14);
		bean.setCh('@');
		bean.setTf(true);
		bean.setName("abcdefg");
		bean.setNalja(new Date());
		
		request.setAttribute("bean", bean);
		request.setAttribute("msg2", "request scope msg...");
		request.getRequestDispatcher("ex02.jsp").forward(request, response);
	}

}
