package com.service.auth;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bean.Authauto;
import com.bean.AuthautoExample;
import com.bean.AuthautoExample.Criteria;
import com.bean.RoleAuth;
import com.bean.RoleAuthExample;
import com.bean.TMember;
import com.bean.TMemberExample;
import com.bean.User;
import com.google.gson.Gson;
import com.mapper.AuthautoMapper;
import com.mapper.RoleAuthMapper;
import com.mapper.TMemberMapper;
import com.mapper.UserMapper;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;
import com.util.CookieUtil;
public class DefaultInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UserMapper UserMapper;
	@Autowired
	TMemberMapper TMemberMapper;
	@Autowired
	RoleAuthMapper RoleAuthMapper;
	@Autowired
	AuthautoMapper AuthautoMapper;
	static  boolean auth_init_flag=false;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
        	Permission permission = ((HandlerMethod) handler).getMethodAnnotation(Permission.class);
       	 	if(permission == null){
	       	 	//不需要权限控制
                return true;
       	 	}
            else{
            	Object userObject = request.getSession().getAttribute("user");
            	if(userObject==null){
            		String username=CookieUtil.getCookie(request, "username");
            		String password=CookieUtil.getCookie(request, "password");
            		if(username!=null&&!"".equals(username)&&password!=null&&!"".equals(password)){
            			TMemberExample tMemberExample=new TMemberExample();
            			tMemberExample.createCriteria().andPhoneEqualTo(username).andPasswordEqualTo(password);
            			List<TMember> tMembers=TMemberMapper.selectByExample(tMemberExample);
            			if(tMembers!=null&&tMembers.size()>0){
            				request.getSession().setAttribute("user", tMembers.get(0));
            				return true;
            			}
            		}
            		
            		
            		HashMap<String, String> map=new HashMap<String, String>();
            		map.put("result", ContantUtil.NOLOGIN);
            		 //用户未登录
            		 PrintWriter out = response.getWriter();
            		 out.write(new Gson().toJson(map));
            		 out.flush();
            		return false;
            	}
            	else{
            		return true;
            	}
            }
        }
        else
       	 return true;   
	 }
}