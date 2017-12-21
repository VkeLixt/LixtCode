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
	 * 根据登录名和密码查询用户
	 * 
	 * @param loginname
	 * @param password
	 * @return
	 * 
	 * @select 后面直接写sql语句
	 * @param 参数与#{}相对应
	 * @Result 如果不写，则会自动映射，实体类的属性名和数据库的字段名需要保持一致
	 */
	@Select("select * from " + RecruitConstants.USERTABLE +" where login_name=#{loginname} and password = #{password}")
	@Results(id = "id", value = {
			@Result(column = "login_name", property = "loginname", javaType = java.lang.String.class),
			@Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
			@Result(column = "card_id", property = "cardId", javaType = java.lang.String.class) })
	User selectLoginnameAndPassword(@Param("loginname") String loginname,@Param("password")String password);
	
	
	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	
	@Select("select * from "+ RecruitConstants.USERTABLE+" where id = #{id}")
	User selectById(@Param("id") Integer id);


	@Select("select * from " + RecruitConstants.USERTABLE + " where login_name=#{loginname}" )
	User selectLoginname(@Param("loginname") String loginname);
	
	/**
	 * 添加用户
	 * @param user
	 */
	@InsertProvider(type = UserDynaSqlMapper.class,method="insertUser")
	void addUser(User user);
	
	
	@Select("select * from "+ RecruitConstants.USERTABLE +" where card_id=#{cardId}")
	User selectCardId(@Param("cardId") String cardId);
	
	
}
