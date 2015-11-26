package com.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 设置cookie
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
	    Cookie cookie = new Cookie(name,value);
	    cookie.setPath("/");
	    if(maxAge>0)  cookie.setMaxAge(maxAge);
	    response.addCookie(cookie);
	}
	
	/**
	 * 根据名字获取cookie
	 * @param request
	 * @param name cookie名字
	 * @return 
	 * @return
	 */
	public static String getCookie(HttpServletRequest  request,String name){
		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
		String value=null;
		if(cookies!=null&&cookies.length>0){
			for(Cookie cookie : cookies){
			    if(cookie.getName().equals(name)){
			    	value=cookie.getValue();
			    }
			}
		}
		
		return value;
	}
}
