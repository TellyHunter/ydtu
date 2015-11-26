package com.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class OutUtil {

	public static String basePath="";
	static{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	}
	
	public static void out(HttpServletResponse response,String result,String url){
		 
		try {
			String typeNum=result.equals("SUCCESS")?"4":"5";
			
			StringBuffer ssString=new StringBuffer("");
			ssString.append("<html xmlns='http://www.w3.org/1999/xhtml'>");
			ssString.append("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>");
			ssString.append("<meta name='viewport' content='width=device-width, initial-scale=1'>");
			ssString.append("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			ssString.append("<link rel='stylesheet' href='"+basePath+"/resource/operate/msgBox/msgbox.css'/>");
			ssString.append("<script src='"+basePath+"/resource/operate/msgBox/msgbox.js'></script>");		
			ssString.append("<body style='background-color:#fff'><a  id='ss' onclick='clickautohide("+typeNum+")'></a></body>");		
			ssString.append("<script>function aa(){location.href='"+basePath+""+url+"'} document.getElementById('ss').click();setTimeout('aa()',500)</script>");		
			ssString.append("</html>");
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			response.getWriter().write(ssString.toString());
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajax_return(HttpServletResponse response ,String contant){
		try {
			response.setCharacterEncoding("utf-8"); 
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			response.getWriter().write(contant);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
