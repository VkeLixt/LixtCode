package com.entor.recruit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.entor.recruit.dao.impl.ResumeWorkDynaSqlMapper;
import com.entor.recruit.domain.ResumeWork;
import com.entor.recruit.utils.RecruitConstants;

public interface ResumeWorkMapper {
	
	@Select("select * from "+ RecruitConstants.RESUMEWORKTABLE +" where resume_id=#{resumeId} order by start_time")
	@Results({
		@Result(column="unit_name",property="unitName",javaType=java.lang.String.class),
		@Result(column="position",property="position",javaType=java.lang.String.class),
		@Result(column="start_time",property="startTime",javaType=java.util.Date.class),
		@Result(column="end_time",property="endTime",javaType=java.util.Date.class),
		@Result(column="resume_id",property="resumeId",javaType=java.lang.Integer.class),
		@Result(column="remark",property="remark",javaType=java.lang.String.class),
		@Result(column="create_date",property="createDate",javaType=java.util.Date.class)})
	List<ResumeWork> selectResumeWork(Integer resumeId);
	
	@InsertProvider(type=ResumeWorkDynaSqlMapper.class,method="insertResumeWork")
	void addReseumeWork(ResumeWork resumeWork);
	
	@UpdateProvider(type=ResumeWorkDynaSqlMapper.class,method="updateResumeWork")
	void flushResumeWork(ResumeWork resumeWork);
	
	@DeleteProvider(type=ResumeWorkDynaSqlMapper.class,method="deleteResumeWork")
	void deleteResumeWork(Map<String, Integer[]> map);

}
