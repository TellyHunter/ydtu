package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Page;
import com.bean.TMember;
import com.bean.TMemberCar;
import com.bean.TMemberCarExample;
import com.bean.TParkInOut;
import com.bean.TParkInOutExample;
import com.mapper.TMemberCarMapper;
import com.mapper.TParkInOutMapper;
import com.service.auth.Permission;
import com.util.ContantUtil;
import com.util.ResultHandleUtil;
import com.util.StringUtil;

@RestController
public class ParkInOutController {
	
	@Autowired
	private TMemberCarMapper tMemberCarDAO;
	@Autowired
	private TParkInOutMapper tParkInOutDAO;
	
	/**
	 * 
	 * @描述: 停车记录异步查询
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/tparkinout/getList")
	public HashMap<String, Object> getList(HttpServletRequest request, HttpServletResponse response, String inCarPlate, String parkId, String beginTime, String endTime, Page page) throws SQLException{
		TMember member = (TMember)request.getSession().getAttribute("user");
		TParkInOutExample example = new TParkInOutExample();
		com.bean.TParkInOutExample.Criteria criteria = example.createCriteria();
		//查询条件及数据
//		Map<String, Object> map = new HashMap<String, Object>();
		/*查询条件*/
		if(StringUtil.isNotEmpty(inCarPlate)){
//			map.put("inCarPlate", inCarPlate);
			criteria.andInCarPlateEqualTo(inCarPlate);
		}
		if(StringUtil.isNotEmpty(parkId)){
//			map.put("parkId", parkId);
			criteria.andParkIdEqualTo(Integer.parseInt(parkId));
		}
		if(StringUtil.isNotEmpty(beginTime)){
//			map.put("beginTime", beginTime);
			criteria.andInTimeGreaterThanOrEqualTo(beginTime);
		}
		if(StringUtil.isNotEmpty(endTime)){
//			map.put("endTime", endTime);
			criteria.andInTimeLessThanOrEqualTo(endTime);
		}
		/*查询条件*/
		TMemberCarExample memberCarExample = new TMemberCarExample();
		com.bean.TMemberCarExample.Criteria memberCarCriteria = memberCarExample.createCriteria();
		memberCarCriteria.andMemberIdEqualTo(member.getId());
		List<TMemberCar> memberCars = tMemberCarDAO.selectByExample(memberCarExample);
		List<String> carPlates = new ArrayList<String>();
		for(int i = 0; null != memberCars && i < memberCars.size() ; i++){
			TMemberCar mCar = memberCars.get(i);
			if(null != mCar){
				String plateString = mCar.getCarPlate();
				carPlates.add(plateString);
			}
		}
		List<TParkInOut> list = new ArrayList<TParkInOut>(); 
		if(carPlates.size() > 0){
			criteria.andInCarPlateIn(carPlates);
			int count = tParkInOutDAO.countByExample(example);
			page.setCount(count);
			example.setLimitStart(page.getStart());
			example.setLimitEnd(page.getPageSize());
			list = tParkInOutDAO.selectByExample(example);
		}
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, list, page);
	}
	
}
