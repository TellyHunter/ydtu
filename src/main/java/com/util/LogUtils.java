package com.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bean.TMember;

public class LogUtils {

	private static Logger inf = Logger.getLogger("INF");

	private static Logger err = Logger.getLogger("ERR");
	 public static void info(String log){
		 inf.info(log);
	 }
	 public static void error(String log,java.lang.Throwable e){
		 err.error(log,e);
	 }
	 public static void error(String log){
		 err.error(log);
	 }
	 public static void infoStart(String name){
		 System.out.println("\n\n\n\n\n");
		 info("------------------------------------"+"【"+name+"】【开始】------------------------------------");
	 }
	 public static void infoEnd(String name){
		 info("------------------------------------"+"【"+name+"】【结束】------------------------------------");
	 }
	 public static void infoRequire(Object... object){
		System.out.println("\n");
		info("------------------------------------"+"【传入的参数】【开始】"+"------------------------------------");
		info(GsonUtil.toJson(object));
		info("------------------------------------"+"【传入的参数】【结束】"+"------------------------------------");
	 }
	 public static void infoResult(Object... object){
		System.out.println("\n");
		info("------------------------------------"+"【返回的结果】【开始】"+"------------------------------------");
		info(GsonUtil.toJson(object));
		info("------------------------------------"+"【返回的结果】【结束】"+"------------------------------------");
	 }
	 public static void infoDatabase(String name,Object object){
		 System.out.println("\n");
		 info("------------------------------------"+"【"+name+"】【开始】"+"------------------------------------");
		 info(GsonUtil.toJson(object));
		 info("------------------------------------"+"【"+name+"】【结束】"+"------------------------------------");
	 }
	 public static void main(String[] args) {
		 infoResult("ee");
	}
}
