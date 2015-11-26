package com.controller;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Charge;
import com.bean.ChargeExample;
import com.bean.Coupon;
import com.bean.CouponExample;
import com.bean.ChargeExample.Criteria;
import com.bean.Page;
import com.bean.TMember;
import com.bean.WxPayDto;
import com.google.gson.Gson;
import com.mapper.ChargeMapper;
import com.mapper.CouponMapper;
import com.service.auth.Permission;
import com.util.AlipayBankCodeUtil;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;
import com.util.DateUtil;
import com.util.MD5Util;
import com.util.OutUtil;
import com.util.RandomUtil;
import com.util.StreamTool;
import com.util.StringUtil;
import com.util.WeixinUtil;

@RestController
public class TChargeController {
	@Autowired
	private ChargeMapper chargeDAO;
	@Autowired
	private CouponMapper couponDAO;
	@Autowired
	private PayComplementController payController;
	/**
	 * 
	 * @描述: 交易记录列表
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/charge/getList")
	public HashMap<String, Object> getList(String beginTime, String endTime,HttpServletRequest request, Page page) throws SQLException {
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		int memberId=tMember.getId();
		ChargeExample example = new ChargeExample();
		Criteria criteria = example.createCriteria();
		/*查询条件*/
		if(StringUtil.isNotEmpty(beginTime)) {
			criteria.andOrderTimeGreaterThanOrEqualTo(beginTime);
		}
		if(StringUtil.isNotEmpty(endTime)) {
			criteria.andOrderTimeLessThanOrEqualTo(endTime);
		}
		criteria.andTMemberIdEqualTo(memberId);
		/*查询条件*/
		
		int count = chargeDAO.countByExample(example);
		page.setCount(count);
		example.setOrderByClause("id desc");	
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List<Charge> list = chargeDAO.selectByExample(example);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, list, page);
	}
	
	/**
	 * 
	 * @描述:返回银行代码、银行名键值对
	 * @作者:testpc
	 */
	@RequestMapping("/bank/getList")
	public HashMap<String, Object> getBankList(){
		HashMap<String, String> map= AlipayBankCodeUtil.getCodeName();
		return ResultHandleUtil.resultHandle(ContantUtil.SUCCESS, map);
	}
	
	/**
	 * 
	 * @描述: 累计充值丶当月充值
	 * @作者: john
	 */
	@RequestMapping("/charge/charge_sum")
	public void charge_sum(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		int memberId=tMember.getId();
		Calendar cal = Calendar.getInstance();
		String day = cal.getActualMaximum(Calendar.DAY_OF_MONTH)+"";
		String beginDateString = DateUtil.getDate("yyyy-MM-01 00:00:00");
		String endDateString = DateUtil.getDate("yyyy-MM-"+ day + " 23:59:59");
		ChargeExample example = new ChargeExample();
		Criteria criteria = example.createCriteria();
		criteria.andTMemberIdEqualTo(memberId);
		/*累计充值*/
		List allChargeList = chargeDAO.selectByExample(example);
		int allCharge = 0;
		for(Object o : allChargeList) {
			Charge charge = (Charge)o;
			allCharge += charge.getAmount().intValue();
		}

		
		/*当月充值*/
		criteria.andOrderTimeBetween(beginDateString, endDateString);
		
		List monChargelist = chargeDAO.selectByExample(example);
		int monCharge = 0;
		for(Object o : monChargelist) {
			Charge charge = (Charge)o;
			monCharge += charge.getAmount().intValue();
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("allCharge", allCharge);
		map.put("monCharge", monCharge);
		Gson gson = new Gson();
		String jsonList = gson.toJson(map);
		OutUtil.ajax_return(response, jsonList);		
	}
	

	
	
	/**
	 * 
	 * @throws SQLException 
	 * @描述:判断是否支付成功
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/charge/getLast_charge")
	public HashMap<String, Object> getLastChage(HttpServletRequest request, String orderId) throws SQLException{
		ChargeExample example = new ChargeExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andResultEqualTo("1");
		int count = chargeDAO.countByExample(example);
		if(count > 0){
			return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
		}else{
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
	}
	
	@Permission
	@RequestMapping("/charge/getBean")
	public HashMap<String, Object> getBean(HttpServletRequest request,int id) throws SQLException{
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, chargeDAO.selectByPrimaryKey(id));
	}
	
	@Permission
	@RequestMapping("/charge/save")
	public HashMap<String, Object>  pay(HttpServletRequest request, Charge charge) throws SQLException{
		
		TMember tMember = (TMember) request.getSession().getAttribute("user");
		int tMemberId = tMember.getId();
	
			
//		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String today = sf.format(new Date());
//		String orderId = today+RandomUtil.getNum(4);
		
		String orderId = RandomUtil.getOrderId();
//		//充值记录表插入一条记录
//		String amount = charge.getAmount().toString();
//		String payType = charge.getType();
//		int num = charge.getNum();
//		int timeType = charge.getTimetype();
//		if(StringUtil.isNotEmpty(amount)){
//			BigDecimal amountdecimal = new BigDecimal(amount);
//			charge.setAmount(amountdecimal);
//		}
		charge.setOrderId(orderId);
		charge.setOrderTime(DateUtil.getDate());
		charge.setResult("0");
		charge.settMemberId(tMemberId);
//		if(payType.equals("1")){
//			charge.setPayType(payType);
//			charge.setNum(num);
//			charge.setTimetype(timeType);
//		}
		chargeDAO.insert(charge);
		
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, charge);
		
		
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @throws IOException 
	 * @描述:手机端微信支付
	 * @作者:testpc
	 */
	@Permission
	@RequestMapping("/weixinPay")
	public HashMap<String, Object> weixinPay(String orderId,HttpServletRequest request) throws IOException{
		if(orderId==null||"".equals(orderId)){
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
		TMember tMember = (TMember) request.getSession().getAttribute("user");
		String openid=tMember.getOpenid();
		String ip = getIpAddr(request);
		ChargeExample chargeExample = new ChargeExample();
		chargeExample.createCriteria().andOrderIdEqualTo(orderId);
		List<Charge> charges=chargeDAO.selectByExample(chargeExample);
		
		if(charges.size()>0){
			Charge charge=charges.get(0);
			BigDecimal amount = charge.getAmount();
			
			//临时缴费
			if(charge.getPayType().equals("3")){
				//得到最早一张还未过期的优惠券
				CouponExample example = new CouponExample();
				example.createCriteria().andMemberIdEqualTo(tMember.getId()).andStatusEqualTo("1").andEndTimeGreaterThanOrEqualTo(DateUtil.getDate("yyyy-MM-dd"));
		//		example.setOrderByClause("id desc");
				
				List<Coupon> couponList =  couponDAO.selectByExample(example);
				if(couponList.size() > 0){
					Coupon cou = couponList.get(0);
					BigDecimal cAmount = null;
					//优惠券面值金额若大于所需金额，则直接使用掉优惠券。如果小于，则返回amount继续用所选择支付方式付款
					if(amount.compareTo(cou.getAmount()) < 0){
						cAmount = amount;
						amount = new BigDecimal(0);
					}else{
						cAmount = cou.getAmount();
						amount = amount.subtract(cou.getAmount());
					}
					
					//Charge表中插入优惠券订单信息
					Charge charge2 = new Charge();
					String cOrderId = RandomUtil.getOrderId();
					charge2.setOrderId(cOrderId);
					charge2.setAmount(cAmount);
					charge2.setOrderTime(DateUtil.getDate());
					charge2.setType("3");
					charge2.setResult("1");
					charge2.settMemberId(tMember.getId());
					charge2.setCarPlate(charge.getCarPlate());
					charge2.setParkId(charge.getParkId());
					charge2.setOrginType(charge.getOrginType());
					charge2.setPayType(charge.getPayType());
					charge2.setCouponId(cou.getId());
					chargeDAO.insert(charge2);
					
					cou.setStatus("2");
					cou.setUseTime(DateUtil.getDate());
					couponDAO.updateByPrimaryKeySelective(cou);
					
					payController.local_notify(cOrderId);
				}
			}
		
		
		
	
			charge.setType("0");
			chargeDAO.updateByPrimaryKeySelective(charge);
			
			WxPayDto tpWxPay = new WxPayDto();
			tpWxPay.setOpenId(openid);
			tpWxPay.setBody("一道通停车");
			tpWxPay.setOrderId(orderId);
			tpWxPay.setSpbillCreateIp(ip);
			tpWxPay.setTotalFee(charge.getAmount()+"");
//			tpWxPay.setTotalFee(0.01+"");
			SortedMap<String, String> map=WeixinUtil.getPackage(tpWxPay);
			return ResultHandleUtil.resultHandle(ContantUtil.SUCCESS, map);
		}
		else{
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
	}
	public String getIpAddr(HttpServletRequest request) {
		 String ip = request.getHeader("x-forwarded-for");
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("Proxy-Client-IP");
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("WL-Proxy-Client-IP");
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getRemoteAddr();
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("http_client_ip");
		 }
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		  ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		 }
		 // 如果是多级代理，那么取第一个ip为客户ip
		 if (ip != null && ip.indexOf(",") != -1) {
		  ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		 }
		 request.setAttribute("ip", ip);
		 return ip;
		}
	
	/**
	 * 支付金额请求接口
	 * @throws IOException 
	 */
	@RequestMapping("/weixin/getOrderInfo")
	public HashMap<String, Object> getOrderInfo(String carPlate) throws IOException{
        String message = "carPlate=" + carPlate + "&key=" + ContantUtil.KEY;
//        message=URLEncoder.encode(message, "UTF-8");
        String sign = MD5Util.MD5Encode(message, "utf-8").toUpperCase();
        String path ="http://www.dmzparking.com/ydto/app/pay/getAmount.htm?carPlate="+carPlate+"&sign="+sign;
        URL url =new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5*1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();    
        byte[] data = StreamTool.stream2Byte(inStream);
        String result=new String(data, "UTF-8");
        HashMap<String, String> map= new Gson().fromJson(result, HashMap.class);
        String result1 = map.get("result");
        if(result1.equals(ContantUtil.SUCCESS)){
        	String amount = map.get("amount");
            String orderId = map.get("orderId");
            String sign1 = map.get("sign");
            
            sign=MD5Util.MD5Encode("amount="+amount+"&orderId="+orderId+"&result=SUCCESS&key="+ContantUtil.KEY+"","utf-8").toUpperCase();
            if(sign.equals(sign1)){
            	return ResultHandleUtil.resultHandle(ContantUtil.SUCCESS, map);
            }
            else{
            	return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
            }
        }
        else{
        	return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
        }
	}
}
