package com.entor.recruit.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.entor.recruit.dao.impl.PhotoDynaSqlMapper;
import com.entor.recruit.domain.Photo;
import com.entor.recruit.utils.RecruitConstants;

/**
 * 用户相片持久层
 * 
 * @author entor11
 *
 */
public interface PhotoMapper {

	/**
	 * 根据id查询用户相片
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from " + RecruitConstants.PHOTOTABLE + " where id = #{id} ")
	@Results({ @Result(column = "user_id", property = "userId", javaType = java.lang.Integer.class) })
	Photo selectById(Integer id);

	/**
	 * 根据用户id查询用户相片
	 * 
	 * @param userId
	 * @return
	 */
	@Select("select * from " + RecruitConstants.PHOTOTABLE + " where user_id = #{userId} ")
	@Results({ @Result(column = "user_id", property = "userId", javaType = java.lang.Integer.class) })
	Photo selectByUserId(Integer userId);

	/**
	 * 动态保存用户相片
	 * 
	 * @param photo
	 */
	@InsertProvider(type = PhotoDynaSqlMapper.class, method = "savePhoto")
	void save(Photo photo);

	/**
	 * 动态更新用户相片
	 * 
	 * @param photo
	 */
	@UpdateProvider(type = PhotoDynaSqlMapper.class, method = "updatePhoto")
	void update(Photo photo);
}
