package com.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.bean.WxPayDto;


/**
 * @author ex_yangxiaoyi
 * 
 */
public class WeixinUtil {
	public static String appid = "wx032837ffa510494f";
	public static String appsecret = "7695e613a3ccbf7b068ae5a863a89b28";
	public static String partner = "1274883801";
	public static String partnerkey = "21pq6h7Kr7958pj2Yd1rIEv254360QjO";
	public static String openId = "oZ59bwaKtXXWW_FJkPSUzkcSVbzs";
	public static String notifyurl =ContantUtil.baseurl+ "/ydtu/weixin/notify_url.htm";																	 // Key

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
	
		/*//微信支付jsApi
		WxPayDto tpWxPay = new WxPayDto();
		tpWxPay.setOpenId(openId);
		tpWxPay.setBody("一道通停车");
		tpWxPay.setOrderId(getNonceStr());
		tpWxPay.setSpbillCreateIp("127.0.0.1");
		tpWxPay.setTotalFee("0.01");
	    getPackage(tpWxPay);*/
	  //扫码支付
	    WxPayDto tpWxPay1 = new WxPayDto();
	    tpWxPay1.setBody("停车一道通");
	    tpWxPay1.setOrderId(getNonceStr());
	    tpWxPay1.setSpbillCreateIp("127.0.0.1");
	    tpWxPay1.setTotalFee("0.01");
		
		System.out.println(getCodeurl(tpWxPay1));
	}
	
	/**
	 * 获取微信扫码支付二维码连接
	 * @throws Exception 
	 */
	public static String getCodeurl(WxPayDto tpWxPayDto) {
		try {
			
		
		// 1 参数
		// 订单号
		String orderId = tpWxPayDto.getOrderId();
		// 总金额以分为单位，不带小数点
		String totalFee = getMoney(tpWxPayDto.getTotalFee());
		// 订单生成的机器 IP
		String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = notifyurl;
		String trade_type = "NATIVE";
		// 商户号
		String mch_id = partner;
		// 随机字符串
		String nonce_str = getNonceStr();
		// 商品描述根据情况修改
		String body = tpWxPayDto.getBody();
		// 商户订单号
		String out_trade_no = orderId;
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", "");
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("total_fee", totalFee);
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);
		packageParams.put("trade_type", trade_type);
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" 
				+ "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" + "<attach></attach>"
				+ "<total_fee>" + totalFee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "</xml>";
		Map map=sendEms(xml);
		String code_url = (String) map.get("code_url");
		return code_url;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	 public static Map sendEms(String param) throws Exception {
	        URL url = new URL("https://api.mch.weixin.qq.com/pay/unifiedorder");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");// 提交模式
	        conn.setConnectTimeout(10000);//连接超时 单位毫秒
	        conn.setReadTimeout(2000);//读取超时 单位毫秒
	        conn.setDoOutput(true);// 是否输入参数
	        byte[] bypes = param.getBytes();
	        conn.getOutputStream().write(bypes);// 输入参数
	        InputStream inStream=conn.getInputStream();
	        String data=new String(readInputStream(inStream), "utf-8");
	        System.out.println("预付单返回："+data);
	        return doXMLParse(data);
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
	/**
	 * 获取随机字符串
	 * @return
	 */
	public static String getNonceStr() {
		
		return RandomUtil.getNum(16);
	}

	/**
	 * 元转换成分
	 * @param money
	 * @return
	 */
	public static String getMoney(String amount) {
		if(amount==null){
			return "";
		}
		// 金额转化为分为单位
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额  
        int index = currency.indexOf(".");  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString(); 
	}
	  /**
		 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
		 * @param strxml
		 * @return
		 * @throws JDOMException
		 * @throws IOException
		 */
		public static Map doXMLParse(String strxml) throws Exception {
			if(null == strxml || "".equals(strxml)) {
				return null;
			}
			
			Map m = new HashMap();
			InputStream in = String2Inputstream(strxml);
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(in);
			Element root = doc.getRootElement();
			List list = root.getChildren();
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String k = e.getName();
				String v = "";
				List children = e.getChildren();
				if(children.isEmpty()) {
					v = e.getTextNormalize();
				} else {
					v = getChildrenText(children);
				}
				
				m.put(k, v);
			}
			
			//关闭流
			in.close();
			
			return m;
		}
		/**
		 * 获取子结点的xml
		 * @param children
		 * @return String
		 */
		public static String getChildrenText(List children) {
			StringBuffer sb = new StringBuffer();
			if(!children.isEmpty()) {
				Iterator it = children.iterator();
				while(it.hasNext()) {
					Element e = (Element) it.next();
					String name = e.getName();
					String value = e.getTextNormalize();
					List list = e.getChildren();
					sb.append("<" + name + ">");
					if(!list.isEmpty()) {
						sb.append(getChildrenText(list));
					}
					sb.append(value);
					sb.append("</" + name + ">");
				}
			}
			
			return sb.toString();
		}
		  public static InputStream String2Inputstream(String str) {
				return new ByteArrayInputStream(str.getBytes());
			}
		  
		  

			/**
			 * 获取请求预支付id报文
			 * @return
			 */
			@SuppressWarnings("static-access")
			public static SortedMap<String, String> getPackage(WxPayDto tpWxPayDto) {
				try {
					
				
				String openId = tpWxPayDto.getOpenId();
				// 1 参数
				// 订单号
				String orderId = tpWxPayDto.getOrderId();
				// 附加数据 原样返回
				String attach = "";
				// 总金额以分为单位，不带小数点
				String totalFee = getMoney(tpWxPayDto.getTotalFee());
				
				// 订单生成的机器 IP
				String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
				// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
				String notify_url = notifyurl;
				String trade_type = "JSAPI";

				// ---必须参数
				// 商户号
				String mch_id = partner;
				// 随机字符串
				String nonce_str = getNonceStr();

				// 商品描述根据情况修改
				String body = tpWxPayDto.getBody();

				// 商户订单号
				String out_trade_no = orderId;

				SortedMap<String, String> packageParams = new TreeMap<String, String>();
				packageParams.put("appid", appid);
				packageParams.put("mch_id", mch_id);
				packageParams.put("nonce_str", nonce_str);
				packageParams.put("body", body);
				packageParams.put("attach", attach);
				packageParams.put("out_trade_no", out_trade_no);

				// 这里写的金额为1 分到时修改
				packageParams.put("total_fee", totalFee);
				packageParams.put("spbill_create_ip", spbill_create_ip);
				packageParams.put("notify_url", notify_url);

				packageParams.put("trade_type", trade_type);
				packageParams.put("openid", openId);

				RequestHandler reqHandler = new RequestHandler(null, null);
				reqHandler.init(appid, appsecret, partnerkey);

				String sign = reqHandler.createSign(packageParams);
				String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
						+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
						+ "</nonce_str>" + "<sign>" + sign + "</sign>"
						+ "<body><![CDATA[" + body + "]]></body>" 
						+ "<out_trade_no>" + out_trade_no
						+ "</out_trade_no>" + "<attach>" + attach + "</attach>"
						+ "<total_fee>" + totalFee + "</total_fee>"
						+ "<spbill_create_ip>" + spbill_create_ip
						+ "</spbill_create_ip>" + "<notify_url>" + notify_url
						+ "</notify_url>" + "<trade_type>" + trade_type
						+ "</trade_type>" + "<openid>" + openId + "</openid>"
						+ "</xml>";
				String prepay_id = "";
				String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
				
				
				Map map=sendEms(xml);
				prepay_id=(String) map.get("prepay_id");
				System.out.println("获取到的预支付ID：" + prepay_id);
				
				
				//获取prepay_id后，拼接最后请求支付所需要的package
				
				SortedMap<String, String> finalpackage = new TreeMap<String, String>();
				String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
				String packages = "prepay_id="+prepay_id;
				finalpackage.put("appId", appid);  
				finalpackage.put("timeStamp", timestamp);  
				finalpackage.put("nonceStr", nonce_str);  
				finalpackage.put("package", packages);  
				finalpackage.put("signType", "MD5");
				//要签名
				reqHandler.init(appid, appsecret, partnerkey);
				String finalsign = reqHandler.createSign(finalpackage);
				finalpackage.put("paySign", finalsign);
				finalpackage.put("package2", packages);
	
				
				return finalpackage;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
}
