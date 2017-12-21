package com.entor.recruit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.ResumeBase;
import com.entor.recruit.service.ResumeBaseService;


@Controller
public class ResumeController {

	@Resource
	private ResumeBaseService resumeBaseService;
	

	
	/**
	 * 根据用户id查询简历
	 * @param userId
	 * @return
	 */
	@RequestMapping("/resume/{userId}/show")
	public @ResponseBody ResumeBase getResumeBaseDisplayListByUserId(@PathVariable Integer userId){
		return resumeBaseService.findDisplayByUserId(userId);
	}
	
	
	/**
	 * 根据用户id查询简历基本信息
	 */
	
	@RequestMapping("/resume/{userId}/base")
	public @ResponseBody ResumeBase getResumeBaseByUserId(@PathVariable Integer userId){
		
		return resumeBaseService.findResumeBaseByUserId(userId);
	}
	
	
	/**
	 * 保存简历基本信息
	 * 
	 * @param resumeBase
	 * @return
	 */
	
	@RequestMapping("/resume/base/save")
	public @ResponseBody String save(ResumeBase resumeBase){
		
		resumeBaseService.saveResumeBase(resumeBase);
		
		return "{\"status\":true}";
	}
	
	
	@RequestMapping("/resume/base/update")
	public @ResponseBody String update(ResumeBase resumeBase){
		resumeBaseService.updateResumeBase(resumeBase);
		return "{\"status\":true}";
	}
	
	@RequestMapping("/recruit/{userId}/checkResume")
	public @ResponseBody String containsResume(@PathVariable Integer userId){
		return "{\"status\":"+resumeBaseService.containsResume(userId)+"}";
	}

	@RequestMapping("/recruit/{userId}/isApplied")
	public @ResponseBody String isPostApplied(@PathVariable Integer userId){
		boolean result = resumeBaseService.isPostApplied(userId);
		if(result){
			return "{\"status\":true}";
		}
		ResumeBase resumeBase = resumeBaseService.findDisplayByUserId(userId);
		return "{\"status\":false,\"resumeId\":"+resumeBase.getId()+"}";
	}
	
	
}
