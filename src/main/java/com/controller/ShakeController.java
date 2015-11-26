package com.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Page;
import com.bean.Shake;
import com.bean.ShakeExample;
import com.bean.TMember;
import com.mapper.ShakeMapper;
import com.service.auth.Permission;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;
import com.util.DateUtil;

@RestController
public class ShakeController {
	@Autowired
	private ShakeMapper shakeDTO;
	@Autowired
	private CouponController couponController;
	/**
	 * 
	 * @throws SQLException 
	 * @描述: 摇一摇随机生成优惠券
	 * @作者:testpc
	 */
	@Permission
	@RequestMapping("/shake/insertCoupon")
	public HashMap<String, Object> insert(HttpServletRequest request) throws SQLException{
		TMember member = (TMember)request.getSession().getAttribute("user");
		int amount = new Random().nextInt(3) + 1;
		Shake bean = new Shake();
		bean.setMemberId(member.getId());
		bean.setCreateTime(DateUtil.getDate());
		bean.setDate(DateUtil.getDate("yyyy-MM-dd"));
		BigDecimal aBigDecimal = new BigDecimal(amount);
		bean.setAmount(aBigDecimal);
		int status = shakeDTO.insert(bean);
		if(status > 0){
			couponController.insert(member.getId(), aBigDecimal, 0, "摇一摇现金券", "3", "today");
		}
		return ResultHandleUtil.dataUpdateResult(status);
	}
	
	/**
	 * 
	 * @描述:获取当天日期摇一摇数量
	 * @作者:testpc
	 */
	@Permission
	@RequestMapping("/shake/getCount")
	public HashMap<String, Object> getCount(HttpServletRequest request){
		TMember member = (TMember)request.getSession().getAttribute("user");
		String nowDate = DateUtil.getDate("yyyy-MM-dd");
		ShakeExample example = new ShakeExample();
		example.createCriteria().andMemberIdEqualTo(member.getId()).andDateEqualTo(nowDate);
		int count = shakeDTO.countByExample(example);
		if(count == 0){
			return ResultHandleUtil.countHandleResult(ContantUtil.SUCCESS, count);
		}else{
			return ResultHandleUtil.countHandleResult(ContantUtil.FAIL, count);
		}
	}
	@Permission
	@RequestMapping("/shake/getList")
	public HashMap<String, Object> getList(HttpServletRequest request, Page page){
		TMember member = (TMember)request.getSession().getAttribute("user");
		ShakeExample example = new ShakeExample();
		example.createCriteria().andMemberIdEqualTo(member.getId());
		int count = shakeDTO.countByExample(example);
		page.setCount(count);
		example.setOrderByClause("id desc");	
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List list = shakeDTO.selectByExample(example);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, list, page);
	}
}
