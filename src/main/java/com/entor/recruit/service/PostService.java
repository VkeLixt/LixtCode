package com.entor.recruit.service;

import java.util.List;
import java.util.Map;

import com.entor.recruit.domain.Post;
import com.entor.recruit.utils.PageModel;

public interface PostService {

	/**
	 * ������Ƹ�ƻ�id��ѯ��ҳ��λ
	 * 
	 * @param id
	 * @param pageIndex
	 * @return
	 */
	PageModel<Post> selectByRecruitmentPlanIdWithParams(Integer id, Integer pageIndex);

	/**
	 * ������Ƹ�ƻ�id��ѯ��λ��¼����
	 * 
	 * @param id
	 * @return
	 */
	Integer selectCountByRecruitmentPlanId(Integer id);

	/**
	 * ������Ƹ�ƻ�id��ѯ��λ��ҳ��¼
	 * 
	 * @param params
	 * @return
	 */
	List<Post> selectByRecruitmentPlanIdWithParams(Map<String, Object> params);
	
	/**
	 * ����id��ѯ��λ��Ϣ
	 * @param id
	 * @return
	 */
	Post findById(Integer id);
}
