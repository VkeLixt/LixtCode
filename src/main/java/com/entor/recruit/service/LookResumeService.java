package com.entor.recruit.service;

import java.util.Map;

public interface LookResumeService {

	/**
	 * ��ѯ���м�����Ϣ
	 * @param userId
	 * @return
	 */
	Map<String, Object> findAllInfo(Integer userId);
}
