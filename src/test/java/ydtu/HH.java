package ydtu;

import java.io.UnsupportedEncodingException;

import com.util.JedisUtil;

import redis.clients.jedis.Jedis;

public class HH {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Jedis js = JedisUtil.getJedis();
		//String aa = new String(js.get("12345").getBytes("utf-8"),"utf-8");
		String aa = js.get("12345");
		System.out.println(aa);
		js.disconnect();
	}

}
