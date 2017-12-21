package com.entor.recruit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.ResumeWorkMapper;
import com.entor.recruit.domain.ResumeWork;
import com.entor.recruit.service.ResumeWorkService;

@Service("resumeWorkService")
public class ResumeWorkServiceImpl implements ResumeWorkService {

	@Resource
	private ResumeWorkMapper resumeWorkMapper;

	@Override
	public List<ResumeWork> findResumeWork(Integer resumeId) {
		
		return resumeWorkMapper.selectResumeWork(resumeId);
	}

	@Override
	public void saveResumeWork(ResumeWork resumeWork) {

		resumeWorkMapper.addReseumeWork(resumeWork);
		
	}

	@Override
	public void updateResumeWork(ResumeWork resumeWork) {

		resumeWorkMapper.flushResumeWork(resumeWork);
	}

	@Override
	public void delResumeWork(Integer[] ids) {

		Map<String, Integer[]> map = new HashMap<>();
		map.put("ids", ids);
		resumeWorkMapper.deleteResumeWork(map);
		
	}
}
