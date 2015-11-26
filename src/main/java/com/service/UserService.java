package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.mapper.UserMapper;

@Service
public class UserService {

	
	@Autowired
	UserMapper userMapper;
	
	@Transactional
	public Integer insert(User user){
		 int a=userMapper.insert(user);
		 int b=9/0;
		 return a;
	}
}
