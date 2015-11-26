package com.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.bean.AlipayDTO;
import com.util.alipay.config.AlipayWapConfig;
import com.util.alipay.util.AlipaySubmit;

public class AlipayWapUtil {

	public static String pay(AlipayDTO alipayDTO,HttpServletResponse response) throws IOException{
////////////////////////////////////请求参数//////////////////////////////////////

//支付类型
String payment_type = "1";
//必填，不能修改
//服务器异步通知页面路径
String notify_url =ContantUtil.baseurl+"/alipay/notify_url.htm";
//需http://格式的完整路径，不能加?id=123这类自定义参数

//页面跳转同步通知页面路径
String return_url = ContantUtil.baseurl+"/alipay/return_url.htm";
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

//商品展示地址
String show_url = new String(alipayDTO.getWIDshow_url().getBytes("ISO-8859-1"),"UTF-8");
//必填，需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

//订单描述
String body = new String(alipayDTO.getWIDbody().getBytes("ISO-8859-1"),"UTF-8");
//选填

//超时时间
String it_b_pay = "";
//选填

//钱包token
String extern_token ="";
//选填


//////////////////////////////////////////////////////////////////////////////////

//把请求参数打包成数组
Map<String, String> sParaTemp = new HashMap<String, String>();
sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
sParaTemp.put("partner", AlipayWapConfig.partner);
sParaTemp.put("seller_id", AlipayWapConfig.seller_id);
sParaTemp.put("_input_charset", AlipayWapConfig.input_charset);
sParaTemp.put("payment_type", payment_type);
sParaTemp.put("notify_url", notify_url);
sParaTemp.put("return_url", return_url);
sParaTemp.put("out_trade_no", out_trade_no);
sParaTemp.put("subject", subject);
sParaTemp.put("total_fee", total_fee);
sParaTemp.put("show_url", show_url);
sParaTemp.put("body", body);
sParaTemp.put("it_b_pay", it_b_pay);
sParaTemp.put("extern_token", extern_token);

//建立请求
String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
return sHtmlText;
	}
}
