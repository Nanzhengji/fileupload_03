package com.nz.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//定义返回信息
		String message = "文件上传成功";
		// 检查是否是一个文件上传请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			// 不是文件上传请求，就不进行文件上传操作
			return;
		} else{
			try {
				//是文件上传
				//调用文件上传工具类
				FileuploadUtil.filupload(request);
			} catch (Exception e) {
				message = "文件上传失败！";
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
}
