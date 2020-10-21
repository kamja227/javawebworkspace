package com.bit.dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/upload.bit")
public class UploadController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// D:\webWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mvc05
		String path = req.getRealPath("./up");
		System.out.println(path);
		req.getRequestDispatcher("upload.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// upload file size
		int fsize = 1 * 1024 * 1024 * 15; // 1MB;
		// upload file path
		String path = req.getRealPath("./up");
		// upload file rename FileRenamePolicy : 만약, 동일한 파일명이 존재하는 파일이라면, 자동으로 파일명 변환해준다.
		FileRenamePolicy frp = new DefaultFileRenamePolicy();
//		String saveDirectory = "D:\\webWorkspace\\up";
//		MultipartRequest mpReq = new MultipartRequest(req, "D:\\webWorkspace\\mvc05\\WebContent\\up");
		
//		http://www.servlets.com/cos/javadoc/     api 참고
		MultipartRequest mpReq = new MultipartRequest(req, path, fsize, "utf-8", frp);
		System.out.println(mpReq.getParameter("sabun"));
		
//		System.out.println(mpReq.getFilesystemName("file1"));
//		System.out.println(mpReq.getOriginalFileName("file1"));
		req.setAttribute("rename", mpReq.getFilesystemName("file1"));
		req.setAttribute("origin", mpReq.getOriginalFileName("file1"));
		req.getRequestDispatcher("download.jsp").forward(req, resp);
	}
}
