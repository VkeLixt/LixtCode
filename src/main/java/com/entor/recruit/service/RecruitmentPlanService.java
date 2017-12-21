package com.entor.recruit.service;


import java.util.List;
import java.util.Map;

import com.entor.recruit.domain.ComboRecruitmentPlanAndPost;
import com.entor.recruit.domain.RecruitmentPlan;
import com.entor.recruit.utils.PageModel;

public interface RecruitmentPlanService {

	
	/**
	 * ��ҳ��ѯ��Ƹ�ƻ��������ط�ҳ����
	 * @param recruitmentPlan
	 * @param pageModel
	 * @return
	 */
	PageModel<RecruitmentPlan> findRecruitmentPlan(RecruitmentPlan recruitmentPlan,PageModel<RecruitmentPlan> pageModel);
	
	
	/**
	 * ��ѯȫ����Ƹ�ƻ�
	 * 
	 * @return
	 */
	List<RecruitmentPlan> findRecruitmentPlan();

	/**
	 * ��ѯȫ����Ƹ�ƻ�����������λ��
	 * 
	 * @return
	 */
	List<RecruitmentPlan> findRecruitmentPlanWithNoPost();

	/**
	 * ����id��ѯ��Ƹ�ƻ�
	 * 
	 * @param id
	 * @return
	 */
	RecruitmentPlan findRecruitmentPlanById(Integer id);

	/**
	 * ����id��ѯ��Ƹ�ƻ������ϸ�λ��ҳ
	 * 
	 * @param id
	 * @param pageIndex
	 * @return
	 */
	PageModel<ComboRecruitmentPlanAndPost> selectRecruitmentPlanIdWithPostByIdAndPage(Integer id, Integer pageIndex);
	
	/**
	 * �����û�id��ѯ�ƻ�����λ�Լ�����������Ϣ
	 * @param userId
	 * @return
	 */
	Map<String, Object> finAppliedResume(Integer userId);
	
	

}
