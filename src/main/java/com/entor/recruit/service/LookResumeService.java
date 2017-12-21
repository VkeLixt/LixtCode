package com.entor.recruit.service;

import java.util.Map;

public interface LookResumeService {

	/**
	 * 查询所有简历信息
	 * @param userId
	 * @return
	 */
	Map<String, Object> findAllInfo(Integer userId);
}
