package com.entor.recruit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.ResumeHome;
import com.entor.recruit.service.ResumeHomeService;

@Controller
public class ResumeHomeController {

	@Resource
	private ResumeHomeService resumeHomeService;
	
	@RequestMapping("/resume/{resumeId}/home")
	public @ResponseBody List<ResumeHome> findHome(@PathVariable Integer resumeId){
		return resumeHomeService.findHome(resumeId);
	}
	
	
	@RequestMapping("/resume/home/save")
	public @ResponseBody String save(ResumeHome resumeHome){
		resumeHomeService.saveResumeHome(resumeHome);
		return "{\"status\":true}";
	}
	
	@RequestMapping("/resume/home/update")
	public @ResponseBody String update(ResumeHome resumeHome){
		resumeHomeService.updateResumeHome(resumeHome);
		return "{\"status\":true}";
	}
	@RequestMapping("/resume/home/delete")
	public @ResponseBody String del(@RequestParam("ids[]") Integer ids[]){
		resumeHomeService.delResumeHome(ids);
		return "{\"status\":true}";
	}
}
