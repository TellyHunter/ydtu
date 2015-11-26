package com.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TMember;
import com.bean.TMemberExample;
import com.mapper.TMemberMapper;
import com.service.auth.Permission;
import com.util.ContantUtil;
import com.util.CookieUtil;
import com.util.LogUtils;
import com.util.ResultHandleUtil;

@RestController
public class LoginController {
	
	@Autowired
	TMemberMapper TMemberDAO;

	@Permission
	@RequestMapping("/operate/index.htm")
	public String operate_index(HttpServletRequest request,HttpServletResponse response){
	    return "/operate/index";  
	}

	@Permission
	@RequestMapping("/property/index.htm")
	public String property_index(HttpServletRequest request,HttpServletResponse response){
	    return "/property/index";  
	}
	
	@Permission
	@RequestMapping("/custom/index")
	public String custom_index(HttpServletRequest request,HttpServletResponse response){
	    return "/custom/index";  
	}
	
	@RequestMapping("/operate/login_page.htm")
	public String operate_login_pge(HttpServletRequest request,HttpServletResponse response,String info){
		if(info!=null&&info.equals("error")){
			request.setAttribute("info", "error");
		}
	       return "/operate/login";  
	}
	@RequestMapping("/property/login_page.htm")
	public String property_login_pge(HttpServletRequest request,HttpServletResponse response){
	       return "/property/login";  
	}
	@RequestMapping("/custom/login_page.htm")
	public String custom_login_pge(HttpServletRequest request,HttpServletResponse response){
		return "/custom/login";
	}
	
	@RequestMapping("/weixin/login_page.htm")
	public String weixin_login_pge(HttpServletRequest request,HttpServletResponse response,String type,String info){
			request.setAttribute("info", info);
	       return "/weixin/login";  
	}
	/**
	 * 
	 * @描述:校验登录用户是否合法
	 * @作者:testpc
	 */
	@RequestMapping("/login.htm")
	public HashMap<String, Object> login(String username,String password,String type,HttpServletRequest request,HttpServletResponse response,String remember) throws SQLException{
		LogUtils.infoStart("登录");
		LogUtils.infoRequire(username,password);
		TMemberExample tMemberExample=new TMemberExample();
		tMemberExample.createCriteria().andPhoneEqualTo(username).andPasswordEqualTo(password);
		List<TMember> tMembers=TMemberDAO.selectByExample(tMemberExample);
		
		if(remember.equals("1")){
			CookieUtil.addCookie(response, "username", username, 365);
			CookieUtil.addCookie(response, "password", password, 365);
		}
		if(ResultHandleUtil.listIsNotNull(tMembers)){
			request.getSession().setAttribute("user", tMembers.get(0));
			LogUtils.infoResult(ContantUtil.SUCCESS);
			return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
		}else{
			LogUtils.infoResult(ContantUtil.FAIL);
			return ResultHandleUtil.resultHandleNoData(ContantUtil.FAIL);
		}
	}
	@RequestMapping("/logout")
	public HashMap<String, Object> logout(HttpServletResponse response,HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return ResultHandleUtil.resultHandleNoData(ContantUtil.SUCCESS);
	}
	

}
