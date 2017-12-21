package com.entor.recruit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.entor.recruit.dao.impl.ResumeHomeDynaSqlMapper;
import com.entor.recruit.domain.ResumeHome;
import com.entor.recruit.utils.RecruitConstants;

public interface ResumeHomeMapper {

	@Select("select * from "+RecruitConstants.RESUMERELATIONSTABLE+" where resume_id=#{resumeId}")
	@Results({
		@Result(column="appellation",property="appellation",javaType=java.lang.String.class),
		@Result(column="name",property="name",javaType=java.lang.String.class),
		@Result(column="party",property="party",javaType=java.lang.String.class),
		@Result(column="nationality",property="nationality",javaType=java.lang.String.class),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="work_unit_position",property="workUnitPosition",javaType=java.lang.String.class),
		@Result(column="resume_id",property="resumeId",javaType=java.lang.Integer.class),
		@Result(column="remark",property="remark",javaType=java.lang.String.class),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class)})
	List<ResumeHome> selectHome(Integer	resumeId);
	
	@InsertProvider(type=ResumeHomeDynaSqlMapper.class,method="insertResumeHome")
	void addReseumeHome(ResumeHome resumeHome);
	
	@UpdateProvider(type=ResumeHomeDynaSqlMapper.class,method="updateResumeHome")
	void flushResumeHome(ResumeHome resumeHome);
	
	@DeleteProvider(type=ResumeHomeDynaSqlMapper.class,method="deleteResumeHome")
	void deleteResumeHome(Map<String, Integer[]> map);
}
