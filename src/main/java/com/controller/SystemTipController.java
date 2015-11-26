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
import com.bean.SystemTip;
import com.bean.SystemTipExample;
import com.mapper.SystemTipMapper;
import com.service.auth.Permission;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;

@RestController
public class SystemTipController {
	@Autowired
	private SystemTipMapper systemTipeDAO;
	
	/**
	 * 
	 * @throws SQLException 
	 * @描述: 系统消息列表
	 * @作者: john
	 */
	@Permission
	@RequestMapping("/systemtip/getList")
	public HashMap<String, Object> getList(HttpServletRequest request, HttpServletResponse response, Page page) throws SQLException{
		SystemTipExample example = new SystemTipExample();
		example.createCriteria().andTypeEqualTo("1");
		example.setOrderByClause("id desc");
		/*查询条件*/
		int count = systemTipeDAO.countByExample(example);
		page.setCount(count);
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List<SystemTip> systemTip = systemTipeDAO.selectByExample(example);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, systemTip, page);		
	}
}
