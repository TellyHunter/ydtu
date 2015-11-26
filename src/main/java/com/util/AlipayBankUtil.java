package com.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.bean.AlipayDTO;
import com.util.alipay.config.AlipayConfig;
import com.util.alipay.util.AlipaySubmit;

public class AlipayBankUtil {

	
	public static String  pay(AlipayDTO alipayDTO,HttpServletResponse response) throws UnsupportedEncodingException{
////////////////////////////////////请求参数//////////////////////////////////////

//支付类型
String payment_type = "1";
//必填，不能修改
//服务器异步通知页面路径
String notify_url = ContantUtil.baseurl+"/alipay/notify_url.htm";
//需http://格式的完整路径，不能加?id=123这类自定义参数

//页面跳转同步通知页面路径
String return_url =  ContantUtil.baseurl+"/alipay/return_url.htm";
//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http:// localhost/

//商户订单号
String out_trade_no = new String(alipayDTO.getWIDout_trade_no().getBytes("ISO-8859-1"),"UTF-8");
//商户网站订单系统中唯一订单号，必填

//订单名称
String subject = new String(alipayDTO.getWIDsubject().getBytes("ISO-8859-1"),"UTF-8");
//必填

//付款金额
String total_fee = new String(alipayDTO.getWIDtotal_fee().getBytes("ISO-8859-1"),"UTF-8");
//必填

//订单描述

String body = new String(alipayDTO.getWIDbody().getBytes("ISO-8859-1"),"UTF-8");
//默认支付方式
String paymethod = "bankPay";
//必填
//默认网银
String defaultbank = new String(alipayDTO.getWIDdefaultbank().getBytes("ISO-8859-1"),"UTF-8");
//必填，银行简码请参考接口技术文档

//商品展示地址
String show_url = new String(alipayDTO.getWIDshow_url().getBytes("ISO-8859-1"),"UTF-8");
//需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

//防钓鱼时间戳
String anti_phishing_key = "";
//若要使用请调用类文件submit中的query_timestamp函数

//客户端的IP地址
String exter_invoke_ip = "";
//非局域网的外网IP地址，如：221.0.0.1


//////////////////////////////////////////////////////////////////////////////////

//把请求参数打包成数组
Map<String, String> sParaTemp = new HashMap<String, String>();
sParaTemp.put("service", "create_direct_pay_by_user");
sParaTemp.put("partner", AlipayConfig.partner);
sParaTemp.put("seller_email", AlipayConfig.seller_email);
sParaTemp.put("_input_charset", AlipayConfig.input_charset);
sParaTemp.put("payment_type", payment_type);
sParaTemp.put("notify_url", notify_url);
sParaTemp.put("return_url", return_url);
sParaTemp.put("out_trade_no", out_trade_no);
sParaTemp.put("subject", subject);
sParaTemp.put("total_fee", total_fee);
sParaTemp.put("body", body);
sParaTemp.put("paymethod", paymethod);
sParaTemp.put("defaultbank", defaultbank);
sParaTemp.put("show_url", show_url);
sParaTemp.put("anti_phishing_key", anti_phishing_key);
sParaTemp.put("exter_invoke_ip", exter_invoke_ip);

//建立请求
String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
return sHtmlText;
	}
}
