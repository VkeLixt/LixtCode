package com.entor.recruit.service;

import java.util.List;

import com.entor.recruit.domain.ResumeEdu;

public interface ResumeEduService {

	void saveResumeEdu(ResumeEdu resumeEdu);
	
	/**
	 * 根据resumeId，查询教育经历信息
	 * @param resumeId
	 * @return
	 */
	List<ResumeEdu> findResumeEduByResumeId(Integer resumeId);
	
	void updateResumeEdu(ResumeEdu resumeEdu);
	
	void delResumeEdu(Integer[] ids);
}
