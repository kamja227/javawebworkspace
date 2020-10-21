package com.bit.controller.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.dao.RecruitmentBoardDao;
import com.bit.model.dto.RecruitmentBoardDto;

@WebServlet("/recruit.bit")
public class RecruitController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RecruitmentBoardDao dao = new RecruitmentBoardDao();
		ArrayList<RecruitmentBoardDto> list = dao.selectAll();
		req.setAttribute("list", list);

		req.getRequestDispatcher("recruit.jsp").forward(req, resp);
	}

}