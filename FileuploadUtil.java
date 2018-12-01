package com.nz.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileuploadUtil {
	public static void filupload (HttpServletRequest request) throws Exception {
		// 1、 创建一个DiskFileItemFactory工厂对象,用户创建FileItem
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传的处理器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//3、接收文件上传表单中的所有请求
		List<FileItem> items = upload.parseRequest(request);
		for (FileItem fileItem : items) {
			// 如果是普通控件，直接获取输入的值
			if (fileItem.isFormField()) {
				String name = fileItem.getString("UTF-8");
			} else {
				//获得上传文件的文件名，写入到指定的位置
				String fileName = fileItem.getName();
				fileItem.write(new File("e:/"+fileName));
				System.out.println("ok---------------------");
			}
		}
	}
}
