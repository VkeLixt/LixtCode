package com.entor.recruit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.ResumeHomeMapper;
import com.entor.recruit.domain.ResumeHome;
import com.entor.recruit.service.ResumeHomeService;

@Service("resumeHomeService")
public class ResumeHomeServiceImpl implements ResumeHomeService {

	@Resource
	private ResumeHomeMapper resumeHomeMapper;

	@Override
	public List<ResumeHome> findHome(Integer resumeId) {
		return resumeHomeMapper.selectHome(resumeId);
	}

	@Override
	public void saveResumeHome(ResumeHome resumeHome) {
		resumeHomeMapper.addReseumeHome(resumeHome);
	}

	@Override
	public void updateResumeHome(ResumeHome resumeHome) {
		resumeHomeMapper.flushResumeHome(resumeHome);
	}

	@Override
	public void delResumeHome(Integer[] ids) {
		Map<String, Integer[]> map = new HashMap<>();
		map.put("ids", ids);
		resumeHomeMapper.deleteResumeHome(map);
	}
}
