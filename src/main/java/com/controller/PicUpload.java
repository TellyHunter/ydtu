package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.util.ContantUtil;
import com.util.GsonUtil;
import com.util.OutUtil;

@Controller
public class PicUpload {

	/**
	 * 
	 * @描述: 异步上传图片
	 * @作者: john
	 */
	@RequestMapping("/tmembercar/uploadImg.htm")
	public void uploadImg(MultipartHttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyyMMddHHmmsss");
		String generationfileName = simpleFormat.format(new Date())+new Random().nextInt(1000);
		//保存路径
		String savePath = request.getServletContext().getRealPath("") + "/resource/uploads";
		String updateP = request.getParameter("updateP");
		String fileNameSuffix=null;
		String fileName= null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(null!=updateP&&!"".equals(updateP)){
			try {
				MultipartFile mf = request.getFile(updateP);
				fileName=mf.getOriginalFilename();
				if(null!=mf&&!"".equals(mf)){
					fileNameSuffix=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
					SaveFileFromInputStream(mf.getInputStream(),savePath,generationfileName+"."+fileNameSuffix);
					map.put("imageName", generationfileName+"."+fileNameSuffix);
					map.put("path", "/resource/uploads/" + generationfileName+"."+fileNameSuffix);
					map.put("status", ContantUtil.SUCCESS);
				}
			} catch (Exception e) {
				map.put("status", ContantUtil.FAIL);
				e.printStackTrace();
			}
			OutUtil.ajax_return(response, GsonUtil.toJson(map));
		}	
	}
	//保存文件   1,文件   2，保存路径 3，文件名称
	public void SaveFileFromInputStream(InputStream stream,String path,String filename) throws IOException{      
		FileOutputStream fs = new FileOutputStream(path + "/" + filename);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}
	
}
