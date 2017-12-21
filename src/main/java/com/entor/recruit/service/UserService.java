package com.entor.recruit.service;

import com.entor.recruit.domain.User;

public interface UserService {

	/**
	 * �û���¼
	 * 
	 * @param loginname
	 * @param password
	 * @return �û�����
	 */
	User login(String loginname,String password);

	
	/**
	 * ����û�
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * �ж��û��Ƿ����
	 * @param loginname
	 * @return
	 */
	User loginname(String loginname);
	
	
	/**
	 * ����CardID�����û�
	 * @param CardId
	 * @return
	 */
	User findCardId(String cardId);
}
