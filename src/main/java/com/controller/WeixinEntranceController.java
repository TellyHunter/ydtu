package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.TMember;
import com.bean.TMemberExample;
import com.bean.TMemberExample.Criteria;
import com.mapper.TMemberMapper;
import com.util.ContantUtil;
import com.util.GsonUtil;
import com.util.HttpurlconnectionPostUtil;
import com.util.LogUtils;
import com.util.OutUtil;
import com.util.WeixinUtil;

@Controller
public class WeixinEntranceController {

	@Autowired
	TMemberMapper TMemberMapper;
	
	@RequestMapping("/weixin/entrance")
	public void entrance(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String result=weixinPre(request);
		String hrefString=request.getParameter("state");
		System.out.println(hrefString+"hrefString");
		if(result.equals(ContantUtil.SUCCESS)){
			hrefMethod(response,OutUtil.basePath+hrefString);
		}
		else{
			hrefMethod(response,OutUtil.basePath+"/page/weixin/login.html");
		}
	}
	public String weixinPre(HttpServletRequest request) throws Exception{
		Object object=request.getSession().getAttribute("user");
		if(object==null){
			String openid=get_openid(request);
			if(openid==null){
				return ContantUtil.FAIL;
			}
			TMember tMember=getTmember(openid);
			if(tMember==null){
				request.getSession().setAttribute("openid", openid);
				return ContantUtil.FAIL;
			}
			else{
				request.getSession().setAttribute("user", tMember);
				return ContantUtil.SUCCESS;
			}
		}
		else {
			return ContantUtil.SUCCESS;
		}
	}
	public String get_openid(HttpServletRequest request) throws Exception{
		LogUtils.info("根据code获取openid");
		String code=request.getParameter("code");
		System.out.println("code"+code);
		String con=HttpurlconnectionPostUtil.sendEms("https://api.weixin.qq.com/sns/oauth2/access_token", "appid="+WeixinUtil.appid+"&secret="+WeixinUtil.appsecret+"&code="+code+"&grant_type=authorization_code");
		Map map=GsonUtil.toMap(con);
		System.out.println("map"+map);
		try {
			String openid=(String) map.get("openid");
			LogUtils.info("openid:"+openid);
			return openid;
		} catch (Exception e) {
			return null;
		}
			
		
	}
	public TMember getTmember(String openid) throws SQLException{
		TMemberExample example=new TMemberExample();
		Criteria cri = example.createCriteria();
		cri.andOpenidEqualTo(openid);
		List<TMember> list=TMemberMapper.selectByExample(example);
		if(list==null||list.size()==0){
			return null;
		}
		else{
			return list.get(0);
		}
	}
	public void hrefMethod(HttpServletResponse response,String href){
		try {
			response.setCharacterEncoding("utf-8"); 
			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
			response.getWriter().write("<script>location.href='"+href+"';</script>");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
