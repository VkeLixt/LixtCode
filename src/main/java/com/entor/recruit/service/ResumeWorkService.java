package com.entor.recruit.service;

import java.util.List;

import com.entor.recruit.domain.ResumeWork;

public interface ResumeWorkService {

	
	List<ResumeWork> findResumeWork(Integer resumeId);
	
	void saveResumeWork(ResumeWork resumeWork);
	
	void updateResumeWork(ResumeWork resumeWork);
	
	void delResumeWork(Integer ids[]);
}
