package com.util.redis;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.LinkedList;
import java.util.List;  
import java.util.Map;  
import java.util.ResourceBundle;
import java.util.Set;  
                                                                 
                                                                 






import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
                                                                 
public class JedisDemo {  
	//private static JedisPool pool;
	private static ShardedJedisPool pool;
	static {
	    ResourceBundle bundle = ResourceBundle.getBundle("redis");
	    if (bundle == null) {
	  throw new IllegalArgumentException(
	    "[redis.properties] is not found!");
	    }
	    JedisPoolConfig config = new JedisPoolConfig();
	  //  config.setMaxActive(Integer.valueOf(bundle
	    //  .getString("redis.pool.maxActive")));
	    config.setMaxIdle(Integer.valueOf(bundle
	      .getString("redis.pool.maxIdle")));
	 //   config.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
	    config.setTestOnBorrow(Boolean.valueOf(bundle
	      .getString("redis.pool.testOnBorrow")));
	    config.setTestOnReturn(Boolean.valueOf(bundle
	      .getString("redis.pool.testOnReturn")));
	   // pool = new JedisPool(config, bundle.getString("redis.ip"),
	   //   Integer.valueOf(bundle.getString("redis.port")));
	    

	    JedisShardInfo jedisShardInfo = new JedisShardInfo(
                bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")));
	    jedisShardInfo.setPassword(bundle.getString("redis.pwd"));
	    JedisShardInfo jedisShardInfo1 = new JedisShardInfo(
                bundle.getString("redis1.ip"), Integer.valueOf(bundle.getString("redis.port")));
	    jedisShardInfo1.setPassword(bundle.getString("redis1.pwd"));
		JedisShardInfo jedisShardInfo2 = new JedisShardInfo(
		                bundle.getString("redis2.ip"), Integer.valueOf(bundle.getString("redis.port")));
		jedisShardInfo2.setPassword(bundle.getString("redis2.pwd"));
		List<JedisShardInfo> list = new LinkedList<JedisShardInfo>();
		list.add(jedisShardInfo);
		list.add(jedisShardInfo1);
		list.add(jedisShardInfo2);
		pool = new ShardedJedisPool(config, list);
	}                                                  
    public void test(){  

  
//从池中获取一个Jedis对象
ShardedJedis jedis = pool.getResource();
String keys = "name";
String value = "snowolf";
//删数据
jedis.del(keys);
//存数据
jedis.set(keys, value);
//取数据
String v = jedis.get(keys);
System.out.println(v);
//释放对象池
pool.returnResource(jedis);

/**队列操作*/
jedis.lpush("aa", "aa");
jedis.lpush("aa", "bb");

System.out.println(jedis.rpop("aa"));
System.out.println(jedis.rpop("aa"));
System.out.println(jedis.rpop("aa"));

/**队列操作*/
    }
    public static void main(String[] args) {     
   JedisDemo t1 = new JedisDemo();  
   t1.test();  
    }  
                                                                 
}