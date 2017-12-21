package com.entor.recruit.dao.impl;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.User;
import com.entor.recruit.utils.RecruitConstants;

public class UserDynaSqlMapper{

	public String insertUser(User user){
		return new SQL(){
			{
				INSERT_INTO(RecruitConstants.USERTABLE);
				if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
					//login_name是数据库名，loginname是？
					VALUES("login_name", "#{loginname}");
				}
				if(user.getPassword()!= null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
				if(user.getUsername()!=null && !user.getUsername().equals("")){
					VALUES("username", "#{username}");
				}

				if(user.getCardId()!=null && !user.getCardId().equals("")){
					VALUES("card_id", "#{cardId}");
				}
				VALUES("status"	, "#{status}");
				VALUES("create_date", "#{createDate}");
			}
		}.toString();
		
		
		
	}

}
