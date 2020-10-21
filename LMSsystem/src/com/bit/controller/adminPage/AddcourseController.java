package com.bit.controller.adminPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.dao.ClassDao;
import com.bit.model.dao.ClassRoomDao;
import com.bit.model.dao.EmployeeDao;
import com.bit.model.dto.ClassRoomDto;
import com.bit.model.dto.EmployeeDto;

@WebServlet("/admin/addcourse.bit")
public class AddcourseController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ClassRoomDao classRoomDao = new ClassRoomDao();
		//��� ������ Ŭ������ ��������
		List<ClassRoomDto> classRoomBean = classRoomDao.getClassRoom();
		
		try {
			
			//employee table �� manageClass �� 0�� ����鸸 ��������
			EmployeeDao employeeDao1 = new EmployeeDao();
			List<EmployeeDto> list1 = employeeDao1.getChangeableGangsaList();
			
			EmployeeDao employeeDao2 = new EmployeeDao();
			List<EmployeeDto> list2=employeeDao2.departmentAll("������");
			
			
			request.setAttribute("ableGangsa", list1);
			request.setAttribute("ableManager", list2);
			
			
		} catch (SQLException e) {
		}
		
		
		request.setAttribute("classroom", classRoomBean);
		request.getRequestDispatcher("../addcourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		try{
			String classTitle=new String(request.getParameter("classTitle").getBytes("iso-8859-1"), "utf-8");
			System.out.println(classTitle);
			String subjectTitle=new String(request.getParameter("subjectTitle").getBytes("iso-8859-1"), "utf-8");
			int teacherId=Integer.parseInt(request.getParameter("teacherId"));
			Date startDate= Date.valueOf(request.getParameter("startDate"));
			Date endDate= Date.valueOf(request.getParameter("endDate"));
			int managerId=Integer.parseInt(request.getParameter("managerId"));
			int classRoom=Integer.parseInt(request.getParameter("classRoom"));
			int status=0;
			String etc = new String(request.getParameter("etc").getBytes("iso-8859-1"),"utf-8");
			
			try {
				ClassDao dao = new ClassDao();
				int result=dao.insertOne(classTitle, subjectTitle, teacherId, startDate, endDate, managerId, classRoom, status, etc);
				if(result>0){
					response.sendRedirect("acourse.bit");
					
					ClassRoomDao classRoomDao = new ClassRoomDao();
					classRoomDao.UpdateInUse(classRoom);
					
					
				}else {
					response.setContentType("text/html; charset=UTF-8");
			         PrintWriter out = response.getWriter();
			         out.println("<script>alert('�߸� �Է��ϼ̽��ϴ�.');location.href='addcourse.bit" + "'</script>");
			         out.flush();  
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}catch(Exception e){
			response.setContentType("text/html; charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>alert('�߸� �Է��ϼ̽��ϴ�.');location.href='addcourse.bit" + "'</script>");
	         out.flush();   
		}
		
		
		
	
	}

}
