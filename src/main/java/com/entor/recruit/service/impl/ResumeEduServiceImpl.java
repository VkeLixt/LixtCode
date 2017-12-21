package com.entor.recruit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.ResumeEduMapper;
import com.entor.recruit.domain.ResumeEdu;
import com.entor.recruit.service.ResumeEduService;

@Service("resumeEduService")
public class ResumeEduServiceImpl implements ResumeEduService {

	@Resource
	private ResumeEduMapper resumeEduMapper;
	
	@Override
	public void saveResumeEdu(ResumeEdu resumeEdu) {
		resumeEduMapper.save(resumeEdu);
	}

	@Override
	public List<ResumeEdu> findResumeEduByResumeId(Integer resumeId) {
		return resumeEduMapper.findResumeEdu(resumeId);
	}

	@Override
	public void updateResumeEdu(ResumeEdu resumeEdu) {

		resumeEduMapper.updateDate(resumeEdu);
	}

	@Override
	public void delResumeEdu(Integer[] ids) {

		Map<String,Integer[]> map= new HashMap<>();
		map.put("ids", ids);
		resumeEduMapper.deleteDate(map);
	}

}
