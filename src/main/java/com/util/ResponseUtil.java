package com.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
@Service
public class ResponseUtil {
	private static Gson gson=new Gson();
	public static void write(Object obj,HttpServletResponse response){
		try {
			response.setCharacterEncoding("utf-8"); 
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			response.getWriter().write(gson.toJson(obj));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
