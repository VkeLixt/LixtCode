package com.entor.recruit.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.service.LookResumeService;

@Controller
public class LookResumeController {

	@Resource
	private LookResumeService lookResumeService;
	
	@RequestMapping("/look/{userId}/showAllInfo")
	public @ResponseBody Map<String,Object> AllInfo(@PathVariable Integer userId){
		return lookResumeService.findAllInfo(userId);
	}
}
