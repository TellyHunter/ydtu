package com.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 读取配置文件
	 * @param filePath
	 * @return
	 */
	public static HashMap<String, String> readProperties(String filePath) {
	     Properties props = new Properties();
	        try {
	        	InputStream in = new PropertiesUtil().getClass().getResourceAsStream(filePath);        
	        	props.load(in);
	            Enumeration en = props.propertyNames();
	            HashMap<String, String> hashMap=new HashMap<String, String>();
	             while (en.hasMoreElements()) {
	              String key = (String) en.nextElement();
	                    String Property = props.getProperty (key);
	                    hashMap.put(key, Property);
	                }
	             return hashMap;
	        } catch (Exception e) {
	         e.printStackTrace();
	        }
	        return null;
	    }
}
