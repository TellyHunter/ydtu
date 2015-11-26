package ydtu;

import java.text.ParseException;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import redis.clients.jedis.Jedis;

import com.controller.PayComplementController;
import com.util.ContantUtil;
import com.util.GsonUtil;
import com.util.HttpurlconnectionPostUtil;
import com.util.JedisUtil;
import com.util.MD5Util;
import com.util.SignUtil;

public class Test {

	
	public static void main(String[] args)  {
		try {
			app_notity();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//上传进场数据到redis
	public static void parkinout_add(){
		int parkId=30;
		String key="X3h27RG70Nia9612";
		String param="{\"parkId\":"+parkId+",\"occurTime\":\"2015-11-05 11:15:29\",\"inCarPlate\":\"粤BH391M\",\"inPicPath\":\"20151105111418_192.168.1.101_92817.jpg\",\"inTime\":\"2015-11-05 11:14:18\",\"inPortId\":8,\"inPortName\":\"测试入口\",\"outCarPlate\":\"粤BH391M\",\"outPicPath\":\"20151105111525_192.168.1.102_38889.jpg\",\"outCarType\":0,\"outTime\":\"2015-11-05 11:15:25\",\"stopTime\":\"0时1分\",\"outType\":0,\"outPortId\":42,\"outPortName\":\"测试出口\",\"needPay\":3.00,\"actualPay\":0.00,\"chargeType\":0,\"dutyPerson\":\"ydt\",\"carNature\":0,\"localId\":\"233\"}";
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("param",param);
		map.put("parkId", parkId+"");
		map.put("sign", MD5Util.MD5Encode(param+key, "utf-8"));
		
		Jedis js = JedisUtil.getJedis();
		js.lpush("parkInOut_add", GsonUtil.toJson(map));
		System.out.println("完成");
	}
	
	public static void getenddate() throws ParseException{
		String ss = new PayComplementController().getEndDate("2016-5-13", "2015-11-09 15:53:29", 2, 2);
		System.out.println(ss);
	}
	public static void redisqushuju(){
	   Jedis js = JedisUtil.getJedis();
	   System.out.println(js.rpop("carPayRule_add"));
	   js.disconnect();
	}
	/**
	 * 
	 * @Description: app缴费通知借口测试
	 * @author: bao
	 * @throws Exception 
	 * @date: 2015年11月13日 上午9:01:32
	 */
	public  static void app_notity() throws Exception{
		String orderId="201511130929425142";
		String code=ContantUtil.SUCCESS;
		String payType="0";
		SortedMap<String, String> sortedMap=new TreeMap<String, String>();
		sortedMap.put("orderId", orderId);
		sortedMap.put("code", code);
		sortedMap.put("payType", payType);
		String sign=SignUtil.createSign(sortedMap, ContantUtil.KEY);
		sortedMap.put("sign", sign);
		//HttpurlconnectionPostUtil.postConnectionSortedMap("http://www.dmzparking.com/ydto/app/pay/notify.htm", sortedMap);
		HttpurlconnectionPostUtil.httpUrlConnection_get("http://www.dmzparking.com/ydto/app/pay/notify.htm?orderId="+orderId+"&code="+code+"&payType="+payType+"&sign="+sign+"");
	}
}
