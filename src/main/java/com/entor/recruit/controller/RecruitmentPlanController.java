package com.entor.recruit.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.recruit.domain.ComboRecruitmentPlanAndPost;
import com.entor.recruit.domain.RecruitmentPlan;
import com.entor.recruit.service.RecruitmentPlanService;
import com.entor.recruit.utils.PageModel;

@Controller
public class RecruitmentPlanController {

	@Resource
	private RecruitmentPlanService recruitmentPlanService;
	
	
	/**
	 * 处理分页查询招聘计划
	 * 
	 * @return
	 */
	@RequestMapping("/welcome/pageList")
	public @ResponseBody PageModel<RecruitmentPlan> pageList(Integer pageIndex){
		PageModel<RecruitmentPlan> pageModel = new PageModel<>();
		pageModel.setPageIndex(pageIndex);
		return recruitmentPlanService.findRecruitmentPlan(null,pageModel);
	}
	
	/**
	 * 处理查询全部招聘计划
	 * 
	 * @param recruitmentPlan
	 * @param pageModel
	 * @return
	 */
	@RequestMapping("/recruit/list")
	public @ResponseBody List<RecruitmentPlan> list() {
		return recruitmentPlanService.findRecruitmentPlan();
	}

	/**
	 * 处理查询全部招聘计划（不关联岗位）
	 * 
	 * @param recruitmentPlan
	 * @param pageModel
	 * @return
	 */
	@RequestMapping("/recruit/listWithNoPost")
	public @ResponseBody List<RecruitmentPlan> listWithNoPost() {
		
		
		return recruitmentPlanService.findRecruitmentPlanWithNoPost();
	}

	/**
	 * 处理职位页面显示的分页列表
	 * @param id
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("/recruit/{id}")
	public @ResponseBody PageModel<ComboRecruitmentPlanAndPost> getById(@PathVariable Integer id, Integer pageIndex) {
		return recruitmentPlanService.selectRecruitmentPlanIdWithPostByIdAndPage(id, pageIndex);
	}
	
	
	
	
	@RequestMapping("/recruit/{userId}/applied")
	public @ResponseBody Map<String,Object> getAppliedResume(@PathVariable Integer userId){
		return recruitmentPlanService.finAppliedResume(userId);
	
	}
}
