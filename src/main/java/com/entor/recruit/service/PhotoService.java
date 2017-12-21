package com.entor.recruit.service;

import com.entor.recruit.domain.Photo;

public interface PhotoService {

	/**
	 * �ж��û��Ƿ�������Ƭ
	 * 
	 * @param userId
	 * @return
	 */
	Boolean isExistPhoto(Integer userId);

	/**
	 * �����û�id��ѯ��Ƭ
	 * 
	 * @param userId
	 * @return
	 */
	Photo findPhotoByUserId(Integer userId);

	/**
	 * �����û�id������Ƭ
	 * 
	 * @param userId
	 * @param path
	 */
	void savePhotoByUserId(Integer userId, String path);

	/**
	 * �����û�id������Ƭ
	 * 
	 * @param userId
	 * @param path
	 */
	void uploadPhotoByUserId(Integer userId, String path);

}
