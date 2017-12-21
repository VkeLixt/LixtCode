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
	 * ���ӽ���������Ϣ
	 * 
	 * @param resumeEdu
	 */
	@InsertProvider(type = ResumeEduDynaSqlMapper.class,method="insertResumeEdu")
	void save(ResumeEdu resumeEdu);
	
	
	/**
	 * ����resumeId��ѯ����������Ϣ
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
	 * ���½�����������
	 */
	
	@UpdateProvider(type=ResumeEduDynaSqlMapper.class,method="updateResumeEdu")
	void updateDate(ResumeEdu resumeEdu);
	
	/**
	 * ����ɾ��
	 */
	@DeleteProvider(type=ResumeEduDynaSqlMapper.class,method="deleteResumeEdu")
	void deleteDate(Map<String,Integer[]> ids);
}
