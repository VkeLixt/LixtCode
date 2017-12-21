package com.entor.recruit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.ResumeWork;
import com.entor.recruit.service.ResumeWorkService;

@Controller
public class ResumeWorkController {

	@Resource
	private ResumeWorkService resumeWorkService;
	
	
	@RequestMapping("/resume/{resumeId}/work")
	public @ResponseBody List<ResumeWork> findResumeWork(@PathVariable Integer resumeId){
		return resumeWorkService.findResumeWork(resumeId);
	}
	
	
	@RequestMapping("/resume/work/save")
	public @ResponseBody String save(ResumeWork resumeWork){
		resumeWorkService.saveResumeWork(resumeWork);
		return "{\"status\":true}";
	}
	
	@RequestMapping("/resume/work/update")
	public @ResponseBody String update(ResumeWork resumeWork){
		resumeWorkService.updateResumeWork(resumeWork);
		return "{\"status\":true}";
	}
	@RequestMapping("/resume/work/delete")
	public @ResponseBody String del(@RequestParam("ids[]") Integer ids[]){
		resumeWorkService.delResumeWork(ids);
		return "{\"status\":true}";
	}
	
}
