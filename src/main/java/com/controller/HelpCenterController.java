package com.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.HelpCenterExample;
import com.bean.Page;
import com.mapper.HelpCenterMapper;
import com.service.auth.Permission;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;
import com.util.StringUtil;

@RestController
public class HelpCenterController {
	@Autowired
	private HelpCenterMapper centerDAO;
	/**
	 * 
	 * @throws SQLException 
	 * @描述: 帮助中心列表
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/helpcenter/getList")
	public HashMap<String, Object> getList(String type, HttpServletRequest request, Page page) throws SQLException{
		HelpCenterExample example = new HelpCenterExample();
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isNotEmpty(type)){
			example.createCriteria().andTypeEqualTo(type);
		}else{
			type = "0";
			example.createCriteria().andTypeEqualTo(0 + "");
		}
		int count = centerDAO.countByExample(example);
		page.setCount(count);
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List list = centerDAO.selectByExample(example);
		map.put("list", list);
		map.put("type", type);
		return ResultHandleUtil.objectHandleResult(ContantUtil.SUCCESS, map, page);	
	}
	
	/**
	 * 
	 * @描述:帮助中心详细信息
	 * @作者:testpc
	 */
	@Permission
	@RequestMapping("/helpcenter/getBean")
	public HashMap<String, Object> getBean(int id){
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS, centerDAO.selectByPrimaryKey(id));
	}
}