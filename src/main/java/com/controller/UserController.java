package com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Page;
import com.bean.User;
import com.bean.UserExample;
import com.mapper.UserMapper;
import com.service.UserService;
import com.service.auth.Permission;
import com.util.ResultHandleUtil;
import com.util.ContantUtil;

@RestController
public class UserController {

	@Autowired
	UserMapper UserMapper;
	@Autowired
	UserService UserService;
	
	/**
	 * 
	 * @Description: user 查询参数，page分页参数
	 * @author: bao
	 * @date: 2015年9月22日 上午11:51:48
	 */
	@Permission
	@RequestMapping("/user/getList")
	public HashMap getList(User user,Page page){
		UserExample userExample=new UserExample();
		/*查询条件*/
		
		
		
		/*查询条件*/
		int count=UserMapper.countByExample(userExample);
		page.setCount(count);
		userExample.setLimitStart(page.getStart());
		userExample.setLimitEnd(page.getPageSize());
		return ResultHandleUtil.listHandleResult(ContantUtil.SUCCESS,  UserMapper.selectByExample(userExample), page);
	}
	/**
	 * 
	 * @Description: user 查询参数，page分页参数
	 * @author: bao
	 * @date: 2015年9月22日 上午11:51:48
	 */
	@RequestMapping("/user/getBean")
	public HashMap getBean(int id){
		return ResultHandleUtil.beanHandleResult(ContantUtil.SUCCESS,  UserMapper.selectByPrimaryKey(id));
	}
	/**
	 * 
	 * @Description: user 查询参数
	 * @author: bao
	 * @date: 2015年9月22日 上午11:51:48
	 */
	@RequestMapping("/user/getCount")
	public HashMap getCount(User user){
		UserExample userExample=new UserExample();
		/*查询条件*/
		
		
		
		/*查询条件*/
		return ResultHandleUtil.countHandleResult(ContantUtil.SUCCESS, UserMapper.countByExample(userExample));
	}
	/**
	 * 
	 * @Description: user 为前端传的user对象
	 * @author: bao
	 * @date: 2015年9月22日 下午12:05:40
	 */
	@RequestMapping("/user/save")
	public HashMap<String, Object> save(User user){
		return ResultHandleUtil.dataUpdateResult(UserMapper.insert(user));
	}
	/**
	 * 
	 * @Description: user 为前端传的user对象
	 * @author: bao
	 * @date: 2015年9月22日 下午12:05:40
	 */
	@RequestMapping("/user/update")
	public HashMap<String, Object> update(User user){
		return ResultHandleUtil.dataUpdateResult(UserMapper.updateByPrimaryKeySelective(user));
	}
	
	/**
	 * 
	 * @Description: id 为前端传的user对象的id
	 * @author: bao
	 * @date: 2015年9月22日 下午12:05:40
	 */
	@RequestMapping("/user/delete")
	public HashMap<String, Object> delete(int id){
		return ResultHandleUtil.dataUpdateResult(UserMapper.deleteByPrimaryKey(id));
	}
}
