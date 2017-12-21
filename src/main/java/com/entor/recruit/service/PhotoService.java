package com.entor.recruit.service;

import com.entor.recruit.domain.Photo;

public interface PhotoService {

	/**
	 * 判断用户是否已有相片
	 * 
	 * @param userId
	 * @return
	 */
	Boolean isExistPhoto(Integer userId);

	/**
	 * 根据用户id查询相片
	 * 
	 * @param userId
	 * @return
	 */
	Photo findPhotoByUserId(Integer userId);

	/**
	 * 根据用户id保存相片
	 * 
	 * @param userId
	 * @param path
	 */
	void savePhotoByUserId(Integer userId, String path);

	/**
	 * 根据用户id更新相片
	 * 
	 * @param userId
	 * @param path
	 */
	void uploadPhotoByUserId(Integer userId, String path);

}
