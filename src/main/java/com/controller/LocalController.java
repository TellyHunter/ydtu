package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TMember;
import com.bean.TMemberCar;
import com.bean.TMemberCarExample;
import com.bean.TParkInOut;
import com.bean.TParkInOutExample;
import com.google.gson.Gson;
import com.mapper.TMemberCarMapper;
import com.mapper.TMemberMapper;
import com.mapper.TParkInOutMapper;
import com.util.CommonUtil;
import com.util.ContantUtil;
import com.util.LogUtils;
import com.util.ResponseUtil;
import com.util.SignUtil;
import com.util.StringUtil;

@RestController
public class LocalController {

	@Autowired
	TMemberCarMapper tMemberCarMapper;
	@Autowired
	TMemberMapper tMemberMapper;
	@Autowired
	TParkInOutMapper tParkInOutMapper;


	
	/**
	 * 余额扣费通知
	 * @描述:
	 * @作者:testpc
	 */
	@RequestMapping("/local/balance_notity")
	public void balance_notity(String carPlate,String amount,String sign, HttpServletResponse response){
		LogUtils.infoStart("余额扣费通知");
		LogUtils.infoRequire(carPlate,amount,sign);
		SortedMap<String, String> sortedMap=new TreeMap<String, String>();
		sortedMap.put("carPlate", CommonUtil.enCode(carPlate));
		sortedMap.put("amount", amount);
		String getSign=SignUtil.createSign(sortedMap, ContantUtil.KEY);
		SortedMap<String, String> sortedMap_return=new TreeMap<String, String>();
		String result=null;
		if(getSign.equals(sign)){
			TMemberCarExample tMemberCarExample=new TMemberCarExample();
			tMemberCarExample.createCriteria().andCarPlateEqualTo(carPlate).andPayAutoEqualTo("1");
			List<TMemberCar> tMemberCars=tMemberCarMapper.selectByExample(tMemberCarExample);
			if(tMemberCars.size()>0){
				int member_id=tMemberCars.get(0).getMemberId();
				TMember member =tMemberMapper.selectByPrimaryKey(member_id);
				if(null != member){
					member.setBalance(member.getBalance().subtract(new BigDecimal(amount)));
					LogUtils.infoDatabase("余额扣费更新", member);
					tMemberMapper.updateByPrimaryKeySelective(member);
					result=ContantUtil.SUCCESS;
				}else{
					result=ContantUtil.FAIL;
				}
			}
			else{
				result=ContantUtil.FAIL;
			}
		
		}
		else{
			result=ContantUtil.SIGNERROR;
		}
		sortedMap_return.put("result", result);
		sortedMap_return.put("msg", ContantUtil.getMsg(result));
		sortedMap_return.put("sign", SignUtil.createSign(sortedMap_return, ContantUtil.KEY));
		LogUtils.infoResult(sortedMap_return);
		ResponseUtil.write(sortedMap_return, response);
	}
	
	/**
	 * 请求车辆状态接口
	 * @throws IOException 
	 */
	@RequestMapping("/app/getCarStatus")
	public HashMap<String, String> getCarStatus(int id) throws IOException{
		System.out.println("请求车辆状态接口");
		TMemberCarExample tMemberCarExample=new TMemberCarExample();
		tMemberCarExample.createCriteria().andMemberIdEqualTo(id);
		List<TMemberCar> tMemberCars=tMemberCarMapper.selectByExample(tMemberCarExample);
		HashMap<String, String> hashMap=new HashMap<String, String>();
		List<String> list=new ArrayList<String>();
		if(tMemberCars.size() > 0){
			for (int i = 0; i < tMemberCars.size(); i++) {
				String carPlate=tMemberCars.get(i).getCarPlate();
				TParkInOutExample tParkInOutExample=new TParkInOutExample();
				tParkInOutExample.createCriteria().andInCarPlateEqualTo(carPlate);
				tParkInOutExample.setOrderByClause("id desc");
				tParkInOutExample.setLimitStart(0);
				tParkInOutExample.setLimitEnd(1);
				List<TParkInOut> tParkInOuts=tParkInOutMapper.selectByExample(tParkInOutExample);
				if(tParkInOuts.size()>0 && StringUtil.stringIsEmpty(tParkInOuts.get(0).getOutTime())){
					
				}
				else{
					list.add(carPlate);
				}
			}
		}
		
		TMember tmember = tMemberMapper.selectByPrimaryKey(id);
		if(list.size()>0){
			hashMap.put("carPlate", new Gson().toJson(list));	
		}
		else{
			hashMap.put("carPlate", "");
		}
		if(tmember!=null){
			hashMap.put("balance", tmember.getBalance()+"");	
		}
		else{
			hashMap.put("balance", "");	
		}
		System.out.println("返回结果"+hashMap);
		return hashMap;
		
	}
	
	
}
