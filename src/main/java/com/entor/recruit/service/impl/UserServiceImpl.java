package com.entor.recruit.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.UserMapper;
import com.entor.recruit.domain.User;
import com.entor.recruit.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User login(String loginname, String password) {
		
		return userMapper.selectLoginnameAndPassword(loginname,password);
	}

	@Override
	public void addUser(User user) {
		user.setUsername(user.getLoginname());
		user.setCreateDate(new Date());
		user.setStatus(1);
		userMapper.addUser(user);	
	}

	@Override
	public User loginname(String loginname) {
		return userMapper.selectLoginname(loginname);
	}

	@Override
	public User findCardId(String cardId) {
		return userMapper.selectCardId(cardId);
	}

	
}
