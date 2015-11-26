package com.util;

import java.io.UnsupportedEncodingException;

public class CommonUtil {
    
	/** 对页面参数解码 */
	public static String deCode(String str) {
		try {
			return java.net.URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	/** 对页面参数编码 */
	public static String enCode(String str) {
		try {
			return java.net.URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
