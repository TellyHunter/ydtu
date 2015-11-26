package com.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	/**
	 * 上传文件
	 * @param file		
	 * @param path		存储路径
	 * @param fileName 不带后缀名
	 * @return
	 */
	public static boolean upload(MultipartFile file,String path,String fileName) {  
        //String path = request.getSession().getServletContext().getRealPath("");//获取项目路径
        //String fileName = file.getOriginalFilename();  //文件原来的名字
		//String fileName = new Date().getTime();  //自己命名
	
		try { 
			File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
            file.transferTo(targetFile); 
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return false;  
    }
	/**
	 * 下载文件
	 * @param path
	 * @param fileName
	 * @return
	 */
	public static ResponseEntity<byte[]> downlad(String path,String fileName) {  
		        try {
		        	File file=new File(path);  
			        HttpHeaders headers = new HttpHeaders(); 
					fileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
					headers.setContentDispositionFormData("attachment", fileName);   
			        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
			        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
			                                          headers, HttpStatus.CREATED);    
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}  
		          catch (IOException e) {
					e.printStackTrace();
				}
		        return null;
		        
    }
	/* 
	 * Java文件操作 获取文件扩展名 
	 * 
	 *  Created on: 2011-8-2 
	 *      Author: blueeagle 
	 */  
	    public static String getExtensionName(String filename) {   
	        if ((filename != null) && (filename.length() > 0)) {   
	            int dot = filename.lastIndexOf('.');   
	            if ((dot >-1) && (dot < (filename.length() - 1))) {   
	                return filename.substring(dot + 1);   
	            }   
	        }   
	        return null;   
	    }   
	/* 
	 * Java文件操作 获取不带扩展名的文件名 
	 * 
	 *  Created on: 2011-8-2 
	 *      Author: blueeagle 
	 */  
	    public static String getFileNameNoEx(String filename) {   
	        if ((filename != null) && (filename.length() > 0)) {   
	            int dot = filename.lastIndexOf('.');   
	            if ((dot >-1) && (dot < (filename.length()))) {   
	                return filename.substring(0, dot);   
	            }   
	        }   
	        return null;   
	    }   
}
