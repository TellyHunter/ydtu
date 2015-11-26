package com.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

	public static Jedis getJedis(){
		Jedis js = new Jedis("112.74.195.113", 6379);
        js.auth("ydt123456");
        return js;
	}
}
