package com.entor.recruit.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.entor.recruit.dao.impl.UserDynaSqlMapper;
import com.entor.recruit.domain.User;
import com.entor.recruit.utils.RecruitConstants;

public interface UserMapper {

	/**
	 * ���ݵ�¼���������ѯ�û�
	 * 
	 * @param loginname
	 * @param password
	 * @return
	 * 
	 * @select ����ֱ��дsql���
	 * @param ������#{}���Ӧ
	 * @Result �����д������Զ�ӳ�䣬ʵ����������������ݿ���ֶ�����Ҫ����һ��
	 */
	@Select("select * from " + RecruitConstants.USERTABLE +" where login_name=#{loginname} and password = #{password}")
	@Results(id = "id", value = {
			@Result(column = "login_name", property = "loginname", javaType = java.lang.String.class),
			@Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
			@Result(column = "card_id", property = "cardId", javaType = java.lang.String.class) })
	User selectLoginnameAndPassword(@Param("loginname") String loginname,@Param("password")String password);
	
	
	/**
	 * ����id��ѯ�û�
	 * 
	 * @param id
	 * @return
	 */
	
	@Select("select * from "+ RecruitConstants.USERTABLE+" where id = #{id}")
	User selectById(@Param("id") Integer id);


	@Select("select * from " + RecruitConstants.USERTABLE + " where login_name=#{loginname}" )
	User selectLoginname(@Param("loginname") String loginname);
	
	/**
	 * ����û�
	 * @param user
	 */
	@InsertProvider(type = UserDynaSqlMapper.class,method="insertUser")
	void addUser(User user);
	
	
	@Select("select * from "+ RecruitConstants.USERTABLE +" where card_id=#{cardId}")
	User selectCardId(@Param("cardId") String cardId);
	
	
}
