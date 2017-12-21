package com.entor.recruit.service;

import com.entor.recruit.domain.User;

public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @param loginname
	 * @param password
	 * @return 用户对象
	 */
	User login(String loginname,String password);

	
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 判断用户是否存在
	 * @param loginname
	 * @return
	 */
	User loginname(String loginname);
	
	
	/**
	 * 根据CardID查找用户
	 * @param CardId
	 * @return
	 */
	User findCardId(String cardId);
}
