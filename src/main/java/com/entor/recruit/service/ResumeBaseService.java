package com.entor.recruit.service;

import com.entor.recruit.domain.ResumeBase;

public interface ResumeBaseService {

	/**
	 * �����û�Id��ѯ�����б���ʾ��Ϣ
	 * 
	 * @return
	 */
	ResumeBase findDisplayByUserId(Integer userId);
	/**
	 * �����û�id��ѯ����������Ϣ
	 * 
	 * @param userId
	 * @return
	 */
	ResumeBase findResumeBaseByUserId(Integer userId);
	
	void saveResumeBase(ResumeBase resumeBase);
	
	void updateResumeBase(ResumeBase resumeBase);
	
	//�ж��Ƿ��������
	boolean containsResume(Integer userId);
	//�ж��û��Ƿ��Ѿ�Ͷ�ݹ�����
	boolean isPostApplied(Integer userId);
}
