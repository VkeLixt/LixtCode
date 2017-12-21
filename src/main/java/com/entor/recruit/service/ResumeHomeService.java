package com.entor.recruit.service;

import java.util.List;

import com.entor.recruit.domain.ResumeHome;

public interface ResumeHomeService {

	List<ResumeHome> findHome(Integer resumeId);
	
	void saveResumeHome(ResumeHome resumeHome);
	
	void updateResumeHome(ResumeHome resumeHome);
	
	void delResumeHome(Integer ids[]);
}
