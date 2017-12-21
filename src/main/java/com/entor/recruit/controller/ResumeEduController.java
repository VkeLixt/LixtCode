package com.entor.recruit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.ResumeEdu;
import com.entor.recruit.service.ResumeEduService;

@Controller
public class ResumeEduController {

	@Resource
	private ResumeEduService resumeEduService;
	
	@PostMapping("/resume/education/save")
	public @ResponseBody String save(ResumeEdu resumeEdu){
		resumeEduService.saveResumeEdu(resumeEdu);
		return "{\"status\":true}";
	}
	
	@RequestMapping("/resume/{resumeId}/education")
	public @ResponseBody List<ResumeEdu> findResumeId(@PathVariable Integer resumeId){
		return resumeEduService.findResumeEduByResumeId(resumeId);
	}
	
	
	@RequestMapping("/resume/education/update")
	public @ResponseBody String update(ResumeEdu resumeEdu){
		resumeEduService.updateResumeEdu(resumeEdu);
		return "{\"status\":true}";
	}
	
	
	@RequestMapping("/resume/education/del")
	public @ResponseBody String delete(@RequestParam("ids[]") Integer ids[]){
		
		resumeEduService.delResumeEdu(ids);
		
		return "{\"status\":true}";
	}
}
