package com.entor.recruit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.entor.recruit.dao.impl.RecruitmentPlanDynaSqlMapper;
import com.entor.recruit.domain.RecruitmentPlan;
import com.entor.recruit.utils.RecruitConstants;

public interface RecruitmentPlanMapper {

	/**
	 * ������Ƹְλ��Ϣ��ʾ
	 */
	
	
	@Select("select * from "+ RecruitConstants.RECRUITMENTPLANTABLE)
	@Results(value = { 
			@Result(column = "id", property = "id", javaType = java.lang.Integer.class),
			@Result(column = "exam_district", property = "examDistrict", javaType = java.lang.String.class),
			@Result(column = "start_time", property = "startTime", javaType = java.util.Date.class),
			@Result(column = "end_time", property = "endTime", javaType = java.util.Date.class) })
	List<RecruitmentPlan> findListWithNoPost();

	
	/**
	 * ����id��ѯ��Ƹ�ƻ�
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from "+RecruitConstants.RECRUITMENTPLANTABLE +" where id = #{id}")
	@Results(value ={
			@Result(column = "id",property = "id",javaType = java.lang.Integer.class),
			@Result(column = "exam_district",property = "examDistrict",javaType = java.lang.String.class),
			@Result(column = "start_time",property = "startTime",javaType = java.util.Date.class),
			@Result(column = "end_tiem",property = "endTime",javaType = java.util.Date.class)
	})
	RecruitmentPlan selectByIdWithNoPost(Integer id);
	
	/**
	 * ��ѯ��Ƹ�ƻ�����
	 * @param params
	 * @return
	 */
	@SelectProvider(type = RecruitmentPlanDynaSqlMapper.class,method="count")
	Integer count(Map<String, Object> params);
	
	
	@SelectProvider(type = RecruitmentPlanDynaSqlMapper.class,method="selectWithParam")
	@Results(value={
			@Result(column="id",property="id",javaType=java.lang.Integer.class),
			@Result(column="exam_district",property="examDistrict",javaType=java.lang.String.class),
			@Result(column="start_time",property="startTime",javaType=java.util.Date.class),
			@Result(column="end_time",property="endTime",javaType=java.util.Date.class),
			@Result(column="id",property="postList",javaType=List.class,many=@Many(select = "com.entor.recruit.dao.PostMapper.selectByRecruitmentPlanId",fetchType=FetchType.EAGER)	)
	})
	List<RecruitmentPlan> selectByPage(Map<String,Object> params);
	
	
	/**
	 * ����id��ѯ��Ƹ�ƻ�
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from " + RecruitConstants.RECRUITMENTPLANTABLE + " where id = #{id} ")
	@Results(value = { //
			@Result(column = "id", property = "id", javaType = java.lang.Integer.class),
			@Result(column = "exam_district", property = "examDistrict", javaType = java.lang.String.class),
			@Result(column = "start_time", property = "startTime", javaType = java.util.Date.class),
			@Result(column = "end_time", property = "endTime", javaType = java.util.Date.class),
			@Result(column = "id", property = "postList", javaType = List.class, 
			many = @Many(select = "com.entor.recruit.dao.PostMapper.selectByRecruitmentPlanId", fetchType = FetchType.EAGER)) })
	RecruitmentPlan selectById(Integer id);
	
	
	/**
	 * ��ѯ��ȫ����Ƹ�ƻ�
	 * 
	 * @return
	 */
	@Select("select * from " + RecruitConstants.RECRUITMENTPLANTABLE)
	@Results(value = { //
			@Result(column = "id", property = "id", javaType = java.lang.Integer.class),
			@Result(column = "exam_district", property = "examDistrict", javaType = java.lang.String.class),
			@Result(column = "start_time", property = "startTime", javaType = java.util.Date.class),
			@Result(column = "end_time", property = "endTime", javaType = java.util.Date.class),
			@Result(column = "id", property = "postList", javaType = List.class, //
			many = @Many(select = "com.entor.recruit.dao.PostMapper.selectByRecruitmentPlanId", fetchType = FetchType.EAGER)) })
	List<RecruitmentPlan> selectAll();

	/**
	 * ��ѯ��ȫ����Ƹ�ƻ���������post��
	 * 
	 * @return
	 */
	@Select("select * from " + RecruitConstants.RECRUITMENTPLANTABLE)
	@Results(value = { 
			@Result(column = "id", property = "id", javaType = java.lang.Integer.class),
			@Result(column = "exam_district", property = "examDistrict", javaType = java.lang.String.class),
			@Result(column = "start_time", property = "startTime", javaType = java.util.Date.class),
			@Result(column = "end_time", property = "endTime", javaType = java.util.Date.class) })
	List<RecruitmentPlan> selectAllWithNoPost();
}
