package com.entor.recruit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.Notice;
import com.entor.recruit.service.NoticeService;

@Controller
public class NoticeController {

	@Resource
	private NoticeService noticeService;
	
	
	/**
	 * 返回最新的前几条通知
	 * @return
	 */
	@RequestMapping("/notice/primary")
	public @ResponseBody List<Notice> primaryNotice(){
		List<Notice> list = noticeService.findLatestNotice();
		return list;
	}
}
