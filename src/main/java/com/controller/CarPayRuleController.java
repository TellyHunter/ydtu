package com.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CarPayRule;
import com.bean.CarPayRuleExample;
import com.mapper.CarPayRuleMapper;
import com.service.auth.Permission;
import com.util.ContantUtil;
import com.util.ResultHandleUtil;

@RestController
public class CarPayRuleController {
	@Autowired
	private CarPayRuleMapper carPayRuleDAO;
	
	@Permission
	@RequestMapping("/carpayrule/getBean")
	public HashMap<String, Object> getBean(int parkId, int localId){
		CarPayRuleExample example = new CarPayRuleExample();
		example.createCriteria().andParkIdEqualTo(parkId).andLocalIdEqualTo(localId);
		List<CarPayRule> list = carPayRuleDAO.selectByExample(example);
		if(list.size() > 0){
			return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, list.get(0));
		}
		return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
	}
	
}
