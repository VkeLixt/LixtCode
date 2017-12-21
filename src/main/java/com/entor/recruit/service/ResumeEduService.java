package com.entor.recruit.service;

import java.util.List;

import com.entor.recruit.domain.ResumeEdu;

public interface ResumeEduService {

	void saveResumeEdu(ResumeEdu resumeEdu);
	
	/**
	 * ����resumeId����ѯ����������Ϣ
	 * @param resumeId
	 * @return
	 */
	List<ResumeEdu> findResumeEduByResumeId(Integer resumeId);
	
	void updateResumeEdu(ResumeEdu resumeEdu);
	
	void delResumeEdu(Integer[] ids);
}
