package com.entor.recruit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.entor.recruit.domain.Post;
import com.entor.recruit.utils.RecruitConstants;

public interface PostMapper {
	
	/**
	 * 根据id查询岗位
	 * @param id
	 * @return
	 */
	@Select("select * from "+RecruitConstants.POSTTABLE+" where id=#{id}")
	@Results(value = { 
			@Result(column = "org_id", property = "organization", javaType = com.entor.recruit.domain.Organization.class,
			one = @One(select = "com.entor.recruit.dao.OrganizationMapper.selectById")),
			@Result(column = "resume_type_id", property = "resumeType", javaType = com.entor.recruit.domain.ResumeType.class,
			one = @One(select = "com.entor.recruit.dao.ResumeTypeMapper.selectById")),
			@Result(column = "recruitment_plan_id", property = "recruitmentPlanId", javaType = java.lang.Integer.class), })
	Post selectById(Integer id);
	

	/**
	 * 根据招聘计划id查询所有岗位
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from " + RecruitConstants.POSTTABLE + " where recruitment_plan_id = #{id} ")
	@Results(value = { 
			@Result(column = "org_id", property = "organization", javaType = com.entor.recruit.domain.Organization.class, 
			one = @One(select = "com.entor.recruit.dao.OrganizationMapper.selectById")),
			@Result(column = "resume_type_id", property = "resumeType", javaType = com.entor.recruit.domain.ResumeType.class, 
			one = @One(select = "com.entor.recruit.dao.ResumeTypeMapper.selectById")),
			@Result(column = "recruitment_plan_id", property = "recruitmentPlanId", javaType = java.lang.Integer.class) })
	List<Post> selectByRecruitmentPlanId(Integer id);
	
	/**
	 * 根据招聘计划id分页查询岗位
	 * 
	 * @param id
	 * @return
	 */
	@Results(value = { 
			@Result(column = "org_id", property = "organization", javaType = com.entor.recruit.domain.Organization.class, 
			one = @One(select = "com.entor.recruit.dao.OrganizationMapper.selectById")),
			@Result(column = "resume_type_id", property = "resumeType", javaType = com.entor.recruit.domain.ResumeType.class,
			one = @One(select = "com.entor.recruit.dao.ResumeTypeMapper.selectById")),
			@Result(column = "recruitment_plan_id", property = "recruitmentPlanId", javaType = java.lang.Integer.class) })
	@Select("select * from " + RecruitConstants.POSTTABLE
			+ " where recruitment_plan_id = #{id} limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ")
	List<Post> selectByRecruitmentPlanIdWithParams(Map<String, Object> params);
	
	

	/**
	 * 根据招聘计划id查询岗位总数
	 * 
	 * @param id
	 * @return
	 */
	@Select("select count(*) from " + RecruitConstants.POSTTABLE + " where recruitment_plan_id = #{id}")
	Integer countByRecruitmentPlanId(@Param("id") Integer id);

}
