package com.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Coupon;
import com.bean.CouponExample;
import com.bean.Page;
import com.bean.TMember;
import com.mapper.CouponMapper;
import com.service.auth.Permission;
import com.util.ContantUtil;
import com.util.DateUtil;
import com.util.RandomUtil;
import com.util.ResultHandleUtil;

@RestController
public class CouponController {
	@Autowired
	private CouponMapper couponDAO;
	
	/**
	 * 
	 * @描述:生成优惠券
	 * dataType: today：当天有效类型, month:暂定为一月内有效
	 * @作者:testpc
	 */
	public  boolean insert(int memberId, BigDecimal amount, int num, String remark, String type, String dataType) throws SQLException{
		String code =  RandomUtil.getOrderId();
		Coupon coupon = new Coupon();
		coupon.setMemberId(memberId);
		coupon.setAmount(amount);
		coupon.setCode(code);
		
		if(dataType.equals("today")){
			//有效期
			coupon.setEndTime(DateUtil.getDate("yyyy-MM-dd"));
		}else if(dataType.equals("month")){
			//有效期
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(new Date());
			calendar.add(Calendar.MONTH, num);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date = calendar.getTime();
			coupon.setEndTime(df.format(date));
		}
		coupon.setStatus("1");
		coupon.setCreateTime(DateUtil.getDate());
		coupon.setRemark(remark);
		coupon.setType(type);
		couponDAO.insert(coupon);
		return true;
	}
	
	@Permission
	@RequestMapping("/coupon/getList")
	public HashMap<String, Object> search(HttpServletRequest request, Page page) throws SQLException{
		TMember tMember=(TMember) request.getSession().getAttribute("user");
		CouponExample example = new CouponExample();
		example.createCriteria().andMemberIdEqualTo(tMember.getId());
		int count = couponDAO.countByExample(example);
		page.setCount(count);
		example.setOrderByClause("id desc");	
		example.setLimitStart(page.getStart());
		example.setLimitEnd(page.getPageSize());
		List list = couponDAO.selectByExample(example);
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS, list, page) ;
	}
}
