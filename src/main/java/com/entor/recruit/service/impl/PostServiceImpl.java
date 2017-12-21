package com.entor.recruit.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.recruit.dao.PostMapper;
import com.entor.recruit.domain.Post;
import com.entor.recruit.service.PostService;
import com.entor.recruit.utils.PageModel;

@Service("postService")
public class PostServiceImpl implements PostService{

	@Resource
	private PostMapper postMapper;
	
	@Override
	public PageModel<Post> selectByRecruitmentPlanIdWithParams(Integer id, Integer pageIndex) {
		return null;
	}

	@Override
	public Integer selectCountByRecruitmentPlanId(Integer id) {
		return postMapper.countByRecruitmentPlanId(id);
	}

	@Override
	public List<Post> selectByRecruitmentPlanIdWithParams(Map<String, Object> params) {
		return postMapper.selectByRecruitmentPlanIdWithParams(params);
	}

	@Override
	public Post findById(Integer id) {
		return postMapper.selectById(id);
	}

}
