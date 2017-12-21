package com.entor.recruit.service;

import java.util.List;
import java.util.Map;

import com.entor.recruit.domain.Post;
import com.entor.recruit.utils.PageModel;

public interface PostService {

	/**
	 * 根据招聘计划id查询分页岗位
	 * 
	 * @param id
	 * @param pageIndex
	 * @return
	 */
	PageModel<Post> selectByRecruitmentPlanIdWithParams(Integer id, Integer pageIndex);

	/**
	 * 根据招聘计划id查询岗位记录总数
	 * 
	 * @param id
	 * @return
	 */
	Integer selectCountByRecruitmentPlanId(Integer id);

	/**
	 * 根据招聘计划id查询岗位分页记录
	 * 
	 * @param params
	 * @return
	 */
	List<Post> selectByRecruitmentPlanIdWithParams(Map<String, Object> params);
	
	/**
	 * 根据id查询岗位信息
	 * @param id
	 * @return
	 */
	Post findById(Integer id);
}
