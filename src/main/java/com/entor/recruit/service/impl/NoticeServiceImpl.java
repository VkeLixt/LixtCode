package com.entor.recruit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.NoticeMapper;
import com.entor.recruit.domain.Notice;
import com.entor.recruit.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Resource
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> findLatestNotice() {
		
		return noticeMapper.selectLatestNotice();
	}

}
