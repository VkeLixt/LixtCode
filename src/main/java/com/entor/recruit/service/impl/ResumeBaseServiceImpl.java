package com.entor.recruit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entor.recruit.dao.ResumeBaseMapper;
import com.entor.recruit.domain.ResumeBase;
import com.entor.recruit.service.ResumeBaseService;


@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("resumeBaseService")
public class ResumeBaseServiceImpl implements ResumeBaseService {

	@Resource
	private ResumeBaseMapper resumeBaseMapper;
	
	@Transactional(readOnly = true)
	@Override
	public ResumeBase findDisplayByUserId(Integer userId) {
		return resumeBaseMapper.selectPartByUserId(userId);
	}

	@Transactional(readOnly = true)
	@Override
	public ResumeBase findResumeBaseByUserId(Integer userId) {
		return resumeBaseMapper.selectByUserId(userId);
	}

	
	//获取下一个人的编号
	 
	private String nextPersonnelNumber(){
		Integer num = Integer.valueOf(resumeBaseMapper.selectMaxPersonnelNumber());
		String numStr = String.valueOf(num+1);
		int length = numStr.length();
		if(length<8){
			for(int i=1;i<=8-length;i++){
				numStr = "0" + numStr;
			}
		}
		return numStr;
	}
	
	@Override
	public void saveResumeBase(ResumeBase resumeBase) {
		
		resumeBase.setPersonnelNumber(nextPersonnelNumber());
		resumeBaseMapper.save(resumeBase);
		
	}

	@Override
	public void updateResumeBase(ResumeBase resumeBase) {
		resumeBaseMapper.update(resumeBase);
	}

	@Override
	public boolean containsResume(Integer userId) {
		return resumeBaseMapper.selectByUserId(userId) != null;
	}

	@Override
	public boolean isPostApplied(Integer userId) {
		ResumeBase resumeBase = resumeBaseMapper.selectByUserId(userId);
		return resumeBase != null && resumeBase.getPostId() != null;
	}

}
