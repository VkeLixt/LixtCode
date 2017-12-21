package com.entor.recruit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.PhotoMapper;
import com.entor.recruit.dao.ResumeBaseMapper;
import com.entor.recruit.dao.ResumeEduMapper;
import com.entor.recruit.dao.ResumeHomeMapper;
import com.entor.recruit.dao.ResumeWorkMapper;
import com.entor.recruit.domain.Photo;
import com.entor.recruit.domain.ResumeBase;
import com.entor.recruit.domain.ResumeEdu;
import com.entor.recruit.domain.ResumeHome;
import com.entor.recruit.domain.ResumeWork;
import com.entor.recruit.service.LookResumeService;

@Service("lookResumeService")
public class LookResumeServiceImpl implements LookResumeService {

	@Resource
	private PhotoMapper photoMapper;
	@Resource
	private ResumeBaseMapper resumeBaseMapper;
	@Resource
	private ResumeEduMapper resumeEduMapper;
	@Resource
	private ResumeWorkMapper resumeWorkMapper;
	@Resource
	private ResumeHomeMapper resumeHomeMapper;
	
	@Override
	public Map<String, Object> findAllInfo(Integer userId) {
		Map<String,Object> map = new HashMap<>();
		Photo photo = photoMapper.selectByUserId(userId);
		ResumeBase resumeBase = resumeBaseMapper.selectByUserId(userId);
		List<ResumeEdu> resumeEdu = resumeEduMapper.findResumeEdu(resumeBase.getId());
		List<ResumeWork> resumeWork = resumeWorkMapper.selectResumeWork(resumeBase.getId());
		List<ResumeHome> resumeHome = resumeHomeMapper.selectHome(resumeBase.getId());
	
		map.put("photo", photo);
		map.put("resumeBase", resumeBase);
		map.put("resumeEdu", resumeEdu);
		map.put("resumeWork", resumeWork);
		map.put("resumeHome", resumeHome);
		
		return map;
	}

}
