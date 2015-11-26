package com.util;

public class ContantUtil {

	public final static String SUCCESS="SUCCESS";
	public final static String FAIL="FAIL";
	public final static String NOAUTH="NOAUTH";
	public final static String NOLOGIN="NOLOGIN";
	public final static String REPEAT="REPEAT";
	public final static String NORULE="NORULE";
	public final static String SIGNERROR="SIGNERROR";//签名错误
	public final static String NODATA="NODATA";  //无数据返回
	public final static String NOCASH="NOCASH";  //余额不足
	public final static String KEY = "b9p855z10z1ll29zrd2ozzf2rm8g5ztp";
	public final static String baseurl = "http://www.dmzparking.com/"; 
	
	
	
	
	public static String getMsg(String key){
		if(key==null){
			return null;
		}
		if(key.equals(ContantUtil.SUCCESS)){
			return "成功";
		}
		else if(key.equals(ContantUtil.SIGNERROR)){
			return "签名错误";
		} 
		else if(key.equals(ContantUtil.NODATA)){
			return "无数据返回";
		} 
		else if(key.equals(ContantUtil.NOCASH)){
			return "余额不足";
		} 
		else{
			return null;
		}
	}
}
