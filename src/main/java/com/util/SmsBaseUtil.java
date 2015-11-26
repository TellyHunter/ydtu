package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SmsBaseUtil {

	public static boolean SendSms(String mobile,String content){
	Integer x_ac=10;//发送信息
	HttpURLConnection httpconn = null;
	String result="-20";
	String memo = content.length()<70?content.trim():content.trim().substring(0, 70);
	StringBuilder sb = new StringBuilder();
	sb.append("http://service.winic.org/sys_port/gateway/?");
	sb.append("id=").append("yidaotong");
	sb.append("&pwd=").append("ydt123456");
	sb.append("&to=").append(mobile);
	try {
		sb.append("&content=").append(URLEncoder.encode(content, "gb2312"));
	} catch (UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}  //注意乱码的话换成gb2312编码
	try {
		URL url = new URL(sb.toString());
		httpconn = (HttpURLConnection) url.openConnection();
		BufferedReader rd = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
		result = rd.readLine();
		rd.close();
	} catch (MalformedURLException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	} finally{
		if(httpconn!=null){
		httpconn.disconnect();
		httpconn=null;
		}
	}
	String resultString=result.substring(0,3);
	if(resultString.equals("000")){
		return true;
	}
	else{
		return false;
	}
	}
	public static void main(String[] args) {
		System.out.println(SendSms("18572652707","一道通"));
	}
}
