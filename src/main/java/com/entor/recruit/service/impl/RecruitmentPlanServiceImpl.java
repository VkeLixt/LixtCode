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

		//��ǰ��Ҫ��ѯ�ƻ�����
		Map<String,Object> params = new HashMap<>();
		params.put("recruitmentPlan", recruitmentPlan);
		Integer recordCount = recruitmentPlanMapper.count(params);
		if(recordCount>0){
			pageModel.setRecordCount(recordCount);
			params.put("pageModel", pageModel);
		}
		
		//��ѯ��ҳ��¼
		
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
		
		// ��ǰ��Ҫ������Ƹ�ƻ�id��ѯ��λ��¼����
		PageModel<Post> postPageModel = new PageModel<>();
		postPageModel.setPageIndex(pageIndex);
		
		Integer recordCount = postService.selectCountByRecruitmentPlanId(id);
		postPageModel.setRecordCount(recordCount);
		params.put("pageModel", postPageModel);
		
		// ������Ƹ�ƻ�id�ͷ�ҳģ�Ͳ�ѯ��λ��ҳ��¼
		List<Post> postList = postService.selectByRecruitmentPlanIdWithParams(params);
		
		// ����ComboRecruitmentPlanAndPost����
		List<ComboRecruitmentPlanAndPost> list = new ArrayList<>();
		
		// ������λ��ҳ��¼
		for(Post post:postList){
			// ����ComboRecruitmentPlanAndPost����
			ComboRecruitmentPlanAndPost recruitmentPlanAndPost = new ComboRecruitmentPlanAndPost();
			// ����post���Ժ�recruitmentPlan����
			recruitmentPlanAndPost.setPost(post);
			recruitmentPlanAndPost.setRecruitmentPlan(recruitmentPlan);
			// ��ComboRecruitmentPlanAndPost��ӵ�����
			list.add(recruitmentPlanAndPost);
		}
		
		// ����ComboRecruitmentPlanAndPost��ҳ����
		PageModel<ComboRecruitmentPlanAndPost> pageModel = new PageModel<>();
		// ���÷�ҳ��������
		pageModel.setRecordCount(recordCount);
		pageModel.setPageIndex(pageIndex);
		pageModel.setList(list);
		
		return pageModel;
	}

	@Override
	public Map<String, Object> finAppliedResume(Integer userId) {
		
		//����Map<String,Object>�����ѯ���
		Map<String, Object> map = new HashMap<>();
		//�����û�id��ѯ������Ϣ
		ResumeBase resumeBase = resumeBaseService.findDisplayByUserId(userId);
		map.put("resumeBase", resumeBase);
		
		//���ݸ�λid��ѯ��λ��Ϣ
		
		Post post = null;
		if(resumeBase != null){
			post = postService.findById(resumeBase.getPostId());
			map.put("post", post);
		}
		
		//������Ƹ�ƻ�id��ѯ�ƻ���Ϣ
		
		RecruitmentPlan recruitmentPlan = null;
		if(post != null){
			recruitmentPlan = recruitmentPlanMapper.selectByIdWithNoPost(post.getRecruitmentPlanId());
			map.put("recruitmentPlan", recruitmentPlan);
		}
		return map;
		
		
	}
}
