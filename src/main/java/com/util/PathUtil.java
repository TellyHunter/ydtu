package com.util;

import java.io.File;

public class PathUtil {

	
	public static String getPath(){
		 if   ("\\".equals(File.separator))  {
			  System.out.println("win系统");
			  return "D:";
		}
	    else{
		   System.out.println("linux");
		   return "/home";
	    }
	}
	
	public static String getRedisSub(){
		 if   ("\\".equals(File.separator))  {//win
			  return "_win";
		}
	    else{//linux
		   return "";
	    }
	}
	
}
