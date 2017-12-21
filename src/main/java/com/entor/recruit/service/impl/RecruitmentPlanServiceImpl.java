package com.entor.recruit.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entor.recruit.dao.RecruitmentPlanMapper;
import com.entor.recruit.domain.ComboRecruitmentPlanAndPost;
import com.entor.recruit.domain.Post;
import com.entor.recruit.domain.RecruitmentPlan;
import com.entor.recruit.domain.ResumeBase;
import com.entor.recruit.service.PostService;
import com.entor.recruit.service.RecruitmentPlanService;
import com.entor.recruit.service.ResumeBaseService;
import com.entor.recruit.utils.PageModel;

@Service("recruitmentPlanService")
public class RecruitmentPlanServiceImpl implements  RecruitmentPlanService {

	@Resource
	private RecruitmentPlanMapper recruitmentPlanMapper;
	
	@Resource
	private PostService postService;
	
	@Autowired
	private ResumeBaseService resumeBaseService;

	@Override
	public PageModel<RecruitmentPlan> findRecruitmentPlan(RecruitmentPlan recruitmentPlan,
			PageModel<RecruitmentPlan> pageModel) {

		//当前需要查询计划总数
		Map<String,Object> params = new HashMap<>();
		params.put("recruitmentPlan", recruitmentPlan);
		Integer recordCount = recruitmentPlanMapper.count(params);
		if(recordCount>0){
			pageModel.setRecordCount(recordCount);
			params.put("pageModel", pageModel);
		}
		
		//查询分页记录
		
		List<RecruitmentPlan> list = recruitmentPlanMapper.selectByPage(params);
		pageModel.setList(list);
		
		return pageModel;

	}

	@Override
	public List<RecruitmentPlan> findRecruitmentPlan() {
		return recruitmentPlanMapper.selectAll();
	}

	@Override
	public List<RecruitmentPlan> findRecruitmentPlanWithNoPost() {
		return recruitmentPlanMapper.selectAllWithNoPost();
	}

	@Override
	public RecruitmentPlan findRecruitmentPlanById(Integer id) {
		return recruitmentPlanMapper.selectById(id);
	}

	@Override
	public PageModel<ComboRecruitmentPlanAndPost> selectRecruitmentPlanIdWithPostByIdAndPage(Integer id,
			Integer pageIndex) {
		
		RecruitmentPlan recruitmentPlan = recruitmentPlanMapper.selectByIdWithNoPost(id);
		
		Map<String,Object> params = new HashMap<>();
		params.put("id"	, id);
		
		// 当前需要根据招聘计划id查询岗位记录总数
		PageModel<Post> postPageModel = new PageModel<>();
		postPageModel.setPageIndex(pageIndex);
		
		Integer recordCount = postService.selectCountByRecruitmentPlanId(id);
		postPageModel.setRecordCount(recordCount);
		params.put("pageModel", postPageModel);
		
		// 根据招聘计划id和分页模型查询岗位分页记录
		List<Post> postList = postService.selectByRecruitmentPlanIdWithParams(params);
		
		// 创建ComboRecruitmentPlanAndPost集合
		List<ComboRecruitmentPlanAndPost> list = new ArrayList<>();
		
		// 遍历岗位分页记录
		for(Post post:postList){
			// 创建ComboRecruitmentPlanAndPost对象
			ComboRecruitmentPlanAndPost recruitmentPlanAndPost = new ComboRecruitmentPlanAndPost();
			// 设置post属性和recruitmentPlan属性
			recruitmentPlanAndPost.setPost(post);
			recruitmentPlanAndPost.setRecruitmentPlan(recruitmentPlan);
			// 将ComboRecruitmentPlanAndPost添加到集合
			list.add(recruitmentPlanAndPost);
		}
		
		// 创建ComboRecruitmentPlanAndPost分页对象
		PageModel<ComboRecruitmentPlanAndPost> pageModel = new PageModel<>();
		// 设置分页对象属性
		pageModel.setRecordCount(recordCount);
		pageModel.setPageIndex(pageIndex);
		pageModel.setList(list);
		
		return pageModel;
	}

	@Override
	public Map<String, Object> finAppliedResume(Integer userId) {
		
		//创建Map<String,Object>保存查询结果
		Map<String, Object> map = new HashMap<>();
		//根据用户id查询简历信息
		ResumeBase resumeBase = resumeBaseService.findDisplayByUserId(userId);
		map.put("resumeBase", resumeBase);
		
		//根据岗位id查询岗位信息
		
		Post post = null;
		if(resumeBase != null){
			post = postService.findById(resumeBase.getPostId());
			map.put("post", post);
		}
		
		//根据招聘计划id查询计划信息
		
		RecruitmentPlan recruitmentPlan = null;
		if(post != null){
			recruitmentPlan = recruitmentPlanMapper.selectByIdWithNoPost(post.getRecruitmentPlanId());
			map.put("recruitmentPlan", recruitmentPlan);
		}
		return map;
		
		
	}
}
