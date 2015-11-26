package com.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

public class HttpurlconnectionPostUtil {


	/**
     * 通过HttpURLConnection模拟post表单提交
     * @throws Exception
     */
    public static String sendEms(String urlString,String params) throws Exception {

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");// 提交模式
        conn.setConnectTimeout(10000);//连接超时 单位毫秒
        conn.setReadTimeout(2000);//读取超时 单位毫秒
        conn.setDoOutput(true);// 是否输入参数

   
        byte[] bypes = params.toString().getBytes();
        conn.getOutputStream().write(bypes);// 输入参数
        InputStream inStream=conn.getInputStream();
        return new String(readInputStream(inStream), "UTF-8");
    }
    
   
    /**
     * 从输入流中读取数据
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len = inStream.read(buffer)) !=-1 ){
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();//网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }
    public String httpUrlConnection_post(String requestUrl,HashMap<String, Object> requestParamsMap){
    	 PrintWriter printWriter = null;  
         BufferedReader bufferedReader = null;  
         // BufferedReader bufferedReader = null;  
         StringBuffer responseResult = new StringBuffer();  
         StringBuffer params = new StringBuffer();  
         HttpURLConnection httpURLConnection = null;  
         // 组织请求参数  
         Iterator it = requestParamsMap.entrySet().iterator();  
         while (it.hasNext()) {  
             Map.Entry element = (Map.Entry) it.next();  
             params.append(element.getKey());  
             params.append("=");  
             params.append(element.getValue());  
             params.append("&");  
         }  
         if (params.length() > 0) {  
             params.deleteCharAt(params.length() - 1);  
         }  
   
         try {  
             URL realUrl = new URL(requestUrl);  
             // 打开和URL之间的连接  
             httpURLConnection = (HttpURLConnection) realUrl.openConnection();  
             // 设置通用的请求属性  
             httpURLConnection.setRequestProperty("accept", "*/*");  
             httpURLConnection.setRequestProperty("connection", "Keep-Alive");  
             httpURLConnection.setRequestProperty("Content-Length", String  
                     .valueOf(params.length()));  
             // 发送POST请求必须设置如下两行  
             httpURLConnection.setDoOutput(true);  
             httpURLConnection.setDoInput(true);  
             // 获取URLConnection对象对应的输出流  
             printWriter = new PrintWriter(httpURLConnection.getOutputStream());  
             // 发送请求参数  
             printWriter.write(params.toString());  
             // flush输出流的缓冲  
             printWriter.flush();  
             // 根据ResponseCode判断连接是否成功  
             int responseCode = httpURLConnection.getResponseCode();  
             if (responseCode != 200) {  
            	 return null;
             } else {  
            	 // 定义BufferedReader输入流来读取URL的ResponseData  
                 bufferedReader = new BufferedReader(new InputStreamReader(  
                         httpURLConnection.getInputStream()));  
    
                 return  bufferedReader.readLine();
             }  
            
         } catch (Exception e) {
        	 e.printStackTrace();
         } finally {  
             httpURLConnection.disconnect();  
             try {  
                 if (printWriter != null) {  
                     printWriter.close();  
                 }  
                 if (bufferedReader != null) {  
                     bufferedReader.close();  
                 }  
             } catch (IOException ex) {  
                 ex.printStackTrace();  
             }  
   
         }  
         return null;
    }
   
    
    public static Object httpUrlConnection_post_SortedMap(String requestUrl,SortedMap<String, Object> sortedMap){
      	 PrintWriter printWriter = null;  
           BufferedReader bufferedReader = null;  
           // BufferedReader bufferedReader = null;  
           StringBuffer responseResult = new StringBuffer();  
           StringBuffer params = new StringBuffer();  
           HttpURLConnection httpURLConnection = null;  
           // 组织请求参数  
           Iterator it = sortedMap.entrySet().iterator();  
           while (it.hasNext()) {  
               Map.Entry element = (Map.Entry) it.next();  
               params.append(element.getKey());  
               params.append("=");  
               params.append(element.getValue());  
               params.append("&");  
           }  
           if (params.length() > 0) {  
               params.deleteCharAt(params.length() - 1);  
           }  
     
           try {  
               URL realUrl = new URL(requestUrl);  
               // 打开和URL之间的连接  
               httpURLConnection = (HttpURLConnection) realUrl.openConnection();  
               // 设置通用的请求属性  
               httpURLConnection.setRequestProperty("accept", "*/*");  
               httpURLConnection.setRequestProperty("connection", "Keep-Alive");  
               httpURLConnection.setRequestProperty("Content-Length", String  
                       .valueOf(params.length()));  
               // 发送POST请求必须设置如下两行  
               httpURLConnection.setDoOutput(true);  
               httpURLConnection.setDoInput(true);  
               // 获取URLConnection对象对应的输出流  
               printWriter = new PrintWriter(httpURLConnection.getOutputStream());  
               // 发送请求参数  
               printWriter.write(params.toString());  
               // flush输出流的缓冲  
               printWriter.flush();  
               // 根据ResponseCode判断连接是否成功  
               int responseCode = httpURLConnection.getResponseCode();  
               if (responseCode != 200) {  
            	   return null;
               } else {  
            	   // 定义BufferedReader输入流来读取URL的ResponseData  
                   bufferedReader = new BufferedReader(new InputStreamReader(  
                           httpURLConnection.getInputStream()));  
                   return bufferedReader.readLine();
               }  
              
           } catch (Exception e) {
          	 e.printStackTrace();
           } finally {  
               httpURLConnection.disconnect();  
               try {  
                   if (printWriter != null) {  
                       printWriter.close();  
                   }  
                   if (bufferedReader != null) {  
                       bufferedReader.close();  
                   }  
               } catch (IOException ex) {  
                   ex.printStackTrace();  
               }  
     
           }
		return null;  
      }
    public static String httpUrlConnection_get(String urlLink) throws Exception{
        //String message="货已发到";
        //message=URLEncoder.encode(message, "UTF-8");
        //System.out.println(message);
        URL url =new URL(urlLink);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5*1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();    
        byte[] data =readInputStream(inStream);
        String result=new String(data, "UTF-8");
        return result;
    }
}
