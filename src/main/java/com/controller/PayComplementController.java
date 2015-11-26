package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bean.Charge;
import com.bean.ChargeExample;
import com.bean.TMember;
import com.bean.TParkCar;
import com.bean.TParkCarExample;
import com.google.gson.Gson;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.mapper.ChargeMapper;
import com.mapper.TMemberMapper;
import com.mapper.TParkCarMapper;
import com.util.ContantUtil;
import com.util.DateUtil;
import com.util.LogUtils;
import com.util.MD5Util;
import com.util.StreamTool;
import com.util.StringUtil;
@Controller
public class PayComplementController {
	@Autowired
	private  ChargeMapper chargeDAO;
	
	@Autowired
	TParkCarMapper TParkCarMapper;
	@Autowired
	private  TMemberMapper tMemberDAO;
	@Autowired
	private CouponController couponController;
	public  void completePay(String orderId) throws SQLException, ParseException, IOException{
		LogUtils.infoStart("支付完成后的操作");
		LogUtils.infoRequire(orderId);
		ChargeExample chargeExample = new ChargeExample();
		ChargeExample.Criteria criteria = chargeExample.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<Charge> list =chargeDAO.selectByExample(chargeExample);//获取该订单号的支付记录
		
		if(list.size()>0){
		  Charge	charge = list.get(0);
		  String payType=charge.getPayType();
		  if(charge.getResult().equals("0")){
			  if(payType.equals("1")){//月卡充值
				  LogUtils.info("进入月卡充值");
				  String carplate = charge.getCarPlate();
				  String orderTime = charge.getOrderTime();
				  int num = charge.getNum();
				  int timeType = charge.getTimetype();
				  TParkCarExample tParkCarExample=new TParkCarExample();
				  tParkCarExample.createCriteria().andCarPlateEqualTo(carplate);
				  List<TParkCar> tParkCars=TParkCarMapper.selectByExample(tParkCarExample);
				  TParkCar tParkCar=tParkCars.get(0);
				  String endTime=tParkCar.getEndDate();
				  if(!StringUtil.isNotEmpty(endTime)){
					 tParkCar.setBeginDate(DateUtil.getDate());
				  }
//				  endTime = endTime.substring(0,10);
				  String endDateString  = getEndDate(endTime,orderTime,timeType,num);
				  tParkCar.setEndDate(endDateString);
				  LogUtils.infoDatabase("更新月卡表", tParkCar);
				  //设置同步状态1：需要同步到本地
				  tParkCar.setIsSync("1");
				  TParkCarMapper.updateByPrimaryKeySelective(tParkCar);//更新月租车缴费表中的数据
			  }else if(payType.equals("2")) {//余额充值
				  LogUtils.info("余额充值");
				TMember tMember = tMemberDAO.selectByPrimaryKey(charge.gettMemberId());
				BigDecimal amounts = tMember.getBalance();
				
				if(amounts!=null){
					amounts = amounts.add(charge.getAmount());
					tMember.setBalance(amounts);
				}else{
					tMember.setBalance(charge.getAmount());
				}
				tMemberDAO.updateByPrimaryKeySelective(tMember);//更新会员充值余额
				
				ChargeExample cExample = new ChargeExample();
				cExample.createCriteria().andTMemberIdEqualTo(tMember.getId()).andResultEqualTo("1");
				List cList = chargeDAO.selectByExample(cExample);
				if(null != cList && cList.size() == 1){
					//首次充值送10元优惠券，有效期一个月
					couponController.insert(tMember.getId(), new BigDecimal(10), 1,"首次充值送优惠券", "2","month");
				}
			  }
			  else if(payType.equals("3")) {//临时缴费
				  LogUtils.info("临时缴费");
				  local_notify(orderId);
			  }
		  }
		  charge.setResult("1");
		  LogUtils.infoDatabase("将订单支付结果置成已支付", charge);
		  chargeDAO.updateByPrimaryKeySelective(charge);//更新支付记录表将状态改为已经支付
		}
		
	}
	public void local_notify(String orderId) throws IOException{
		String message ="code="+ContantUtil.SUCCESS+"&orderId="+orderId+"&payType=0";
//        message=URLEncoder.encode(message, "UTF-8");
        String sign = MD5Util.MD5Encode(message+"&key=" + ContantUtil.KEY, "utf-8").toUpperCase();
        message=message+"&sign="+sign;
        String path ="http://www.dmzparking.com/ydto/app/pay/notify.htm?"+message;
        URL url =new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5*1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();    
        byte[] data = StreamTool.stream2Byte(inStream);
        String result=new String(data, "UTF-8");
        HashMap<String, String> map= new Gson().fromJson(result, HashMap.class);
        System.out.println("接收到的返回："+map);
        String result1 = map.get("result");
        if(result1.equals(ContantUtil.SUCCESS)){
        	
        }
        else{
        	
        }
	}
	public   String getEndDate(String endTime,String orderTime,int timeType,int num) throws ParseException{
		  if(endTime.length()<10){
			  String[] endtimes=endTime.split("-");
			  if(endtimes[1].length()<2){
				  endtimes[1]="0"+endtimes[1];
			  }
			  if(endtimes[2].length()<2){
				  endtimes[2]="0"+endtimes[2];
			  }
			  endTime=endtimes[0]+"-"+endtimes[1]+"-"+endtimes[2];
		  }
		  
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		  Date date2 = df.parse(endTime);
		  Date date1 = df.parse(orderTime);
		  Date date = null;
		  
		  if(date2.compareTo(date1)>0){//结束日期大于订单日期
			  Calendar calendar = Calendar.getInstance();
			  calendar.setTime(date2);
			  switch (timeType) {
			case 1:
				calendar.add(Calendar.DATE, num);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				
				break;
			case 2:
				calendar.add(Calendar.MONTH, num);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				break;
			case 3:
				calendar.add(Calendar.MONTH, num*3);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				break;
			case 4:
				calendar.add(Calendar.YEAR, num);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				break;
				
			}
			
		  }else{
			  Calendar calendar = Calendar.getInstance();
			  calendar.setTime(date1);
			  switch (timeType) {
			  
			case 1:
				calendar.add(Calendar.DATE, num);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				
				break;
			case 2:
				calendar.add(Calendar.MONTH, num);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				break;
			case 3:
				calendar.add(Calendar.MONTH, num*4);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				break;
			case 4:
				calendar.add(Calendar.YEAR, num);
				date = calendar.getTime();
//				tcarpayment.setEndDate(df.format(date));
				break;
				
			}
			  
		  }
		  
		  return df.format(date);
	}
	
	

}
