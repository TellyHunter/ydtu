package com.controller;

import java.util.HashMap;
import java.util.SortedMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.WxPayDto;
import com.util.ContantUtil;
import com.util.RandomUtil;
import com.util.ResultHandleUtil;
import com.util.WeixinAppUtil;

@RestController
public class WeinxinAppController {

	@RequestMapping("weixinapp/pay")
	public HashMap<String, Object> pay(){
		//微信支付jsApi
			WxPayDto tpWxPay = new WxPayDto();
			tpWxPay.setBody("停车一道通");
			tpWxPay.setOrderId(RandomUtil.getNum(16));
			tpWxPay.setSpbillCreateIp("127.0.0.1");
			tpWxPay.setTotalFee("0.01");
		    SortedMap<String, String> data = WeixinAppUtil.getPackage(tpWxPay);
		    return ResultHandleUtil.resultHandle(ContantUtil.SUCCESS, data);
	}
}
