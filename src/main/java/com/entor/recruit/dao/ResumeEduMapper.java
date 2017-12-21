package com.entor.recruit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.entor.recruit.dao.impl.ResumeEduDynaSqlMapper;
import com.entor.recruit.domain.ResumeEdu;
import com.entor.recruit.utils.RecruitConstants;

public interface ResumeEduMapper {

	/**
	 * 
	 * 增加教育经历信息
	 * 
	 * @param resumeEdu
	 */
	@InsertProvider(type = ResumeEduDynaSqlMapper.class,method="insertResumeEdu")
	void save(ResumeEdu resumeEdu);
	
	
	/**
	 * 根据resumeId查询教育经历信息
	 */
	@Select("select * from "+ RecruitConstants.RESUMEEDUCATIONTABLE +" where resume_id=#{resumeId} order by start_time")
	@Results({
		@Result(column="school_name",property="schoolName",javaType=java.lang.String.class),
		@Result(column="major",property="major",javaType=java.lang.String.class),
		@Result(column="degree",property="degree",javaType=java.lang.String.class),
		@Result(column="start_time",property="startTime",javaType=java.util.Date.class),
		@Result(column="end_time",property="endTime",javaType=java.util.Date.class),
		@Result(column="resume_id",property="resumeId",javaType=java.lang.Integer.class),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class)})
	List<ResumeEdu> findResumeEdu(Integer resumeId);
	
	
	/**
	 * 更新教育经历数据
	 */
	
	@UpdateProvider(type=ResumeEduDynaSqlMapper.class,method="updateResumeEdu")
	void updateDate(ResumeEdu resumeEdu);
	
	/**
	 * 批量删除
	 */
	@DeleteProvider(type=ResumeEduDynaSqlMapper.class,method="deleteResumeEdu")
	void deleteDate(Map<String,Integer[]> ids);
}
