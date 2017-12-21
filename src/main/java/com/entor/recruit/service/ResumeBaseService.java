package com.entor.recruit.service;

import com.entor.recruit.domain.ResumeBase;

public interface ResumeBaseService {

	/**
	 * 根据用户Id查询简历列表显示信息
	 * 
	 * @return
	 */
	ResumeBase findDisplayByUserId(Integer userId);
	/**
	 * 根据用户id查询简历基本信息
	 * 
	 * @param userId
	 * @return
	 */
	ResumeBase findResumeBaseByUserId(Integer userId);
	
	void saveResumeBase(ResumeBase resumeBase);
	
	void updateResumeBase(ResumeBase resumeBase);
	
	//判断是否包含简历
	boolean containsResume(Integer userId);
	//判断用户是否已经投递过简历
	boolean isPostApplied(Integer userId);
}
