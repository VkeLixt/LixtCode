package com.entor.recruit.dao.impl;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.Photo;
import com.entor.recruit.utils.RecruitConstants;

public class PhotoDynaSqlMapper {

	/**
	 * 动态保存用户相片
	 * 
	 * @param photo
	 * @return
	 */
	public String savePhoto(Photo photo) {
		return new SQL() {
			{
				INSERT_INTO(RecruitConstants.PHOTOTABLE);
				if (photo != null) {
					if (photo.getDescription() != null && !photo.getDescription().equals("")) {
						VALUES("description", "#{description}");
					}
					if (photo.getPath() != null && !photo.getPath().equals("")) {
						VALUES("path", "#{path}");
					}
					if (photo.getUserId() != null && !photo.getUserId().equals("")) {
						VALUES("user_id", "#{userId}");
					}
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}

	/**
	 * 根据用户id动态更新用户相片
	 * 
	 * @param photo
	 * @return
	 */
	public String updatePhoto(Photo photo) {
		return new SQL() {
			{
				UPDATE(RecruitConstants.PHOTOTABLE);
				if (photo != null) {
					if (photo.getDescription() != null && !photo.getDescription().equals("")) {
						SET("description = #{description}");
					}
					if (photo.getPath() != null && !photo.getPath().equals("")) {
						SET("path = #{path}");
					}
					if (photo.getUserId() != null && !photo.getUserId().equals("")) {
						SET("user_id = #{userId}");
					}
					if (photo.getRemark() != null && !photo.getRemark().equals("")) {
						SET("remark = #{remark}");
					}
					WHERE(" user_id = #{userId} ");
				}
			}
		}.toString();
	}
}
