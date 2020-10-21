package com.bit.controller.userMypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.model.dao.AttendanceDao;
import com.bit.model.dto.AttendanceDto;
import com.bit.model.dto.StudentDto;



@WebServlet("/myattendance.bit")
public class MyAttendanceController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentDto bean = (StudentDto) session.getAttribute("stuBean");

		int pageNum = 0;

		try {
			pageNum = Integer.parseInt(request.getParameter("page"));

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pageNum=1;
		} catch (NullPointerException e1) {
			e1.printStackTrace();
			pageNum=1;
		}

		
		
		
		
		int start = -1;
		start = (pageNum - 1) * 10 + 1;

		AttendanceDao dao = new AttendanceDao();
		ArrayList<AttendanceDto> list = dao.getAttendanceList(bean.getStudentIdx(), start, 10);
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAttendanceStatus());
		}
		request.setAttribute("attendancelist", list);

		request.getRequestDispatcher("myattendance.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
