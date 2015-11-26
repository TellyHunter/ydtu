package com.util.redis;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.apache.catalina.ha.backend.Sender;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

public class RedisTestPub {
	  public static void main(String[] args) {
		  for (int i = 0; i < 10; i++) {

			  send(i);
		}
		  
	  }
	  
	  static void send(int i){

		    Jedis jedis = new Jedis("192.168.0.151");
		    try {
		      Bean bean = new Bean();
		      bean.setName("test="+i);
		      bean.setPwd("123="+i);
		  //使用ObjectOutputStream和ByteArrayOutputStream将对象转换成字节流
		      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      ObjectOutputStream oos = new ObjectOutputStream(baos);
		      oos.writeObject(bean);
		      String msg1 = baos.toString("ISO-8859-1");//指定字符集将字节流解码成字符串，否则在订阅时，转换会有问题。
		      // msg1 = URLEncoder.encode(msg1, "UTF-8");
		      jedis.publish("foo", msg1);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		  
	  }
	}