package com.entor.recruit.service;


import java.util.List;
import java.util.Map;

import com.entor.recruit.domain.ComboRecruitmentPlanAndPost;
import com.entor.recruit.domain.RecruitmentPlan;
import com.entor.recruit.utils.PageModel;

public interface RecruitmentPlanService {

	
	/**
	 * 分页查询招聘计划，并返回分页对象
	 * @param recruitmentPlan
	 * @param pageModel
	 * @return
	 */
	PageModel<RecruitmentPlan> findRecruitmentPlan(RecruitmentPlan recruitmentPlan,PageModel<RecruitmentPlan> pageModel);
	
	
	/**
	 * 查询全部招聘计划
	 * 
	 * @return
	 */
	List<RecruitmentPlan> findRecruitmentPlan();

	/**
	 * 查询全部招聘计划（不关联岗位）
	 * 
	 * @return
	 */
	List<RecruitmentPlan> findRecruitmentPlanWithNoPost();

	/**
	 * 根据id查询招聘计划
	 * 
	 * @param id
	 * @return
	 */
	RecruitmentPlan findRecruitmentPlanById(Integer id);

	/**
	 * 根据id查询招聘计划并整合岗位分页
	 * 
	 * @param id
	 * @param pageIndex
	 * @return
	 */
	PageModel<ComboRecruitmentPlanAndPost> selectRecruitmentPlanIdWithPostByIdAndPage(Integer id, Integer pageIndex);
	
	/**
	 * 根据用户id查询计划，岗位以及简历基本信息
	 * @param userId
	 * @return
	 */
	Map<String, Object> finAppliedResume(Integer userId);
	
	

}
