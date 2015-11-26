package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CompanyPark;
import com.bean.CompanyParkExample;
import com.bean.CompanyParkExample.Criteria;
import com.bean.Page;
import com.mapper.CompanyParkMapper;
import com.util.ContantUtil;
import com.util.ResultHandleUtil;

@RestController
public class CompanyParkController {

	
	@Autowired
	CompanyParkMapper companyParkMapper;
	
	@RequestMapping("/companyPark/getList")
	public HashMap getList(CompanyPark companyPark,Page page,HttpServletResponse response,String positionX2,String positionY2){
		CompanyParkExample companyParkExample=new CompanyParkExample();
		Criteria cri = companyParkExample.createCriteria();
		String PositionX=companyPark.getPositionX();
		if(PositionX!=null&&!"".equals(PositionX)&&positionX2!=null&&!"".equals(positionX2)){
			cri.andPositionXGreaterThan(PositionX);
			cri.andPositionXLessThan(positionX2);
		}
		String PositionY=companyPark.getPositionY();
		if(PositionY!=null&&!"".equals(PositionY)&&positionY2!=null&&!"".equals(positionY2)){
			cri.andPositionYGreaterThan(PositionY);
			cri.andPositionYLessThan(positionY2);
		}
		
		int count = companyParkMapper.countByExample(companyParkExample);
		page.setCount(count);
		companyParkExample.setLimitStart(page.getStart());
		companyParkExample.setLimitEnd(page.getPageSize());
		
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, companyParkMapper.selectByExample(companyParkExample), page);
	}
	
}
