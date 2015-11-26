package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/*
	 * 返回格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getDate(){
		SimpleDateFormat sdfDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfDateFormat.format(new Date());
	}
	/**
	 * 
	 * @param simpleDateFormat 格式
	 * @return
	 */
	public static String getDate(String simpleDateFormat){
		
		SimpleDateFormat sdfDateFormat=new SimpleDateFormat(simpleDateFormat);
		return sdfDateFormat.format(new Date());
	}
	/**
	 * 自定义时间
	 * @param date
	 * @param simpleDateFormat
	 * @return
	 */
	public static String getDate(Date date,String simpleDateFormat){
		
		SimpleDateFormat sdfDateFormat=new SimpleDateFormat(simpleDateFormat);
		return sdfDateFormat.format(date);
	}
	
	/**
	 * 时间差  天、时、分
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	public static String diff_time(String startTime,String endTime) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date d1 = df.parse(endTime);//"2004-03-26 13:31:40");
	    Date d2 = df.parse(startTime);//"2004-01-02 11:30:24");
	    long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
	    long days = diff / (1000 * 60 * 60 * 24);
	    long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
	    long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
//	    System.out.println(""+days+"天"+hours+"小时"+minutes+"分");
	    return days+"天"+hours+"小时"+minutes+"分";
	} 

	
	/** 
	 * 判断时间是否在时间段内 
	 *  
	 * @param date 
	 *            当前时间 yyyy-MM-dd HH:mm:ss 
	 * @param strDateBegin 
	 * @param strDateEnd 
	 * @return 
	 */  
	public static boolean isInDate(Date date, String strDateBegin,  
	        String strDateEnd) {  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String strDate = sdf.format(date);  
	    // 截取当前时间时分秒  
	    int strDateH = Integer.parseInt(strDate.substring(11, 13));  
	    int strDateM = Integer.parseInt(strDate.substring(14, 16));  
	    int strDateS = Integer.parseInt(strDate.substring(17, 19));  
	    // 截取开始时间时分秒  
	    int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));  
	    int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));  
	    int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));  
	    // 截取结束时间时分秒  
	    int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));  
	    int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));  
	    int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));  
	    if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {  
	        // 当前时间小时数在开始时间和结束时间小时数之间  
	        if (strDateH > strDateBeginH && strDateH < strDateEndH) {  
	            return true;  
	            // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间  
	        } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM  
	                && strDateM <= strDateEndM) {  
	            return true;  
	            // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间  
	        } else if (strDateH == strDateBeginH && strDateM == strDateBeginM  
	                && strDateS >= strDateBeginS && strDateS <= strDateEndS) {  
	            return true;  
	        }  
	        // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数  
	        else if (strDateH >= strDateBeginH && strDateH == strDateEndH  
	                && strDateM <= strDateEndM) {  
	            return true;  
	            // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数  
	        } else if (strDateH >= strDateBeginH && strDateH == strDateEndH  
	                && strDateM == strDateEndM && strDateS <= strDateEndS) {  
	            return true;  
	        } else {  
	            return false;  
	        }  
	    } else {  
	        return false;  
	    }  
	}
	
	
}
