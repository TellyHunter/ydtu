package com.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Page;
import com.bean.TCompanyPark;
import com.bean.TCompanyParkExample;
import com.mapper.TCompanyParkMapper;
import com.service.auth.Permission;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;

@RestController
public class TCompanyParkController {

	@Autowired
	private TCompanyParkMapper companyParkDAO;

	/**
	 * 
	 * @描述: 异步获取停车场
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/companypark/getList")
	public HashMap<String, Object> getParkList(HttpServletRequest request, HttpServletResponse response, Page page) throws SQLException{
		TCompanyParkExample example = new TCompanyParkExample();
		/*查询条件*/
		int count = companyParkDAO.countByExample(example);
		page.setCount(count);
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List<TCompanyPark> comParkList = companyParkDAO.selectByExample(example);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, comParkList, page);
	}
	
	/**
	 * 
	 * @描述:根据停车场id获得停车场 
	 * @作者:testpc
	 */
	@RequestMapping("/companypark/getBean")
	public HashMap<String, Object> getBean(int id){
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, companyParkDAO.selectByPrimaryKey(id));
	}
	
}
