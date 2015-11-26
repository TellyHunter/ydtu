package com.util.redis;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.apache.tomcat.jni.Thread;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisTestSub {
	  public static void main(String[] args) {
	    Jedis jedis = new Jedis("192.168.0.151");
	    JedisPubSub jedisPubSub = new JedisPubSub() {
	      @Override
	      public void onUnsubscribe(String channel, int subscribedChannels) {
	      }

	      @Override
	      public void onSubscribe(String channel, int subscribedChannels) {
	      }

	      @Override
	      public void onPUnsubscribe(String pattern, int subscribedChannels) {
	      }

	      @Override
	      public void onPSubscribe(String pattern, int subscribedChannels) {
	      }

	      @Override
	      public void onPMessage(String pattern, String channel,
	          String message) {
	      }

	      @Override
	      public void onMessage(String channel, String message) {
	    	  
	        try {
	          ByteArrayInputStream bis = new ByteArrayInputStream(
	              message.getBytes("ISO-8859-1"));//此处指定字符集将字符串编码成字节数组，此处的字符集需要与发布时的字符集保持一致
	          ObjectInputStream ois = new ObjectInputStream(bis);
	          Bean bean = (Bean) ois.readObject();
	          System.out.println("接收："+bean.getName());
	          System.out.println("接收："+bean.getPwd());
	        } catch (Exception e) {
	          e.printStackTrace();
	        } finally {

	        }
	      }
	    };
	    jedis.subscribe(jedisPubSub, "foo");
	  }
	}
