package com.entor.recruit.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.entor.recruit.dao.impl.ResumeBaseDynaSqlMapper;
import com.entor.recruit.domain.ResumeBase;
import com.entor.recruit.utils.RecruitConstants;

public interface ResumeBaseMapper {
	
	
	/**
	 * �����û�id��ѯ����������Ϣȫ���ֶ�
	 * 
	 * @param userId
	 * @return
	 */
	@Select("select * from "+ RecruitConstants.RESUMEBASETABLE +" where user_id = #{userId}")
	@Results({ 
		@Result(column = "personnel_number", property = "personnelNumber", javaType = java.lang.String.class),
		@Result(column = "user_id", property = "userId", javaType = java.lang.Integer.class),
		@Result(column = "race",property = "race",javaType=java.lang.String.class),
		@Result(column = "birthday",property = "birthday",javaType=java.util.Date.class),
		@Result(column = "native_place", property = "nativePlace", javaType = java.lang.String.class),
		@Result(column = "permanent_address", property = "permanentAddress", javaType = java.lang.String.class),
		@Result(column = "source_place", property = "sourcePlace", javaType = java.lang.String.class),
		@Result(column = "time_to_join_party", property = "timeToJoinParty", javaType = java.util.Date.class),
		@Result(column = "highest_education", property = "highestEducation", javaType = java.lang.String.class),
		@Result(column = "highest_degree", property = "highestDegree", javaType = java.lang.String.class),
		@Result(column = "education_school", property = "educationSchool", javaType = java.lang.String.class),
		@Result(column = "curr_employer", property = "currEmployer", javaType = java.lang.String.class),
		@Result(column = "time_to_start_work", property = "timeToStartWork", javaType = java.util.Date.class),
		@Result(column = "computer_certificate", property = "computerCertificate", javaType = java.lang.String.class),
		@Result(column = "professional_qualification", property = "professionalQualification", javaType = java.lang.String.class),
		@Result(column = "professional_speciality", property = "professionalSpeciality", javaType = java.lang.String.class),
		@Result(column = "foreign_languages", property = "foreignLanguages", javaType = java.lang.String.class),
		@Result(column = "foreign_languages_certificate", property = "foreignLanguagesCertificate", javaType = java.lang.String.class),
		@Result(column = "card_id", property = "cardId", javaType = java.lang.String.class),
		@Result(column = "post_id",property ="postId",javaType = java.lang.Integer.class),
		@Result(column = "residence_address", property = "residenceAddress", javaType = java.lang.String.class),
		@Result(column = "is_kin_work_here", property = "isKinWorkHere", javaType = java.lang.Integer.class) })
	ResumeBase selectByUserId(Integer userId);
	
	
	/**
	 * �����û�id��ѯ����������Ϣ�����ֶ�
	 * 
	 * @param userId
	 * @return
	 */
	
	@Select("select * from " + RecruitConstants.RESUMEBASETABLE +" where user_id=#{userId}")
	@Results({
			@Result(column = "personnel_number", property = "personnelNumber", javaType = java.lang.String.class),
			@Result(column = "user_id", property = "userId", javaType = java.lang.Integer.class),
			@Result(column = "race",property = "race",javaType=java.lang.String.class),
			@Result(column = "birthday",property = "birthday",javaType=java.util.Date.class),
			@Result(column = "native_place", property = "nativePlace", javaType = java.lang.String.class),
			@Result(column = "permanent_address", property = "permanentAddress", javaType = java.lang.String.class),
			@Result(column = "source_place", property = "sourcePlace", javaType = java.lang.String.class),
			@Result(column = "time_to_join_party", property = "timeToJoinParty", javaType = java.util.Date.class),
			@Result(column = "highest_education", property = "highestEducation", javaType = java.lang.String.class),
			@Result(column = "highest_degree", property = "highestDegree", javaType = java.lang.String.class),
			@Result(column = "education_school", property = "educationSchool", javaType = java.lang.String.class),
			@Result(column = "curr_employer", property = "currEmployer", javaType = java.lang.String.class),
			@Result(column = "time_to_start_work", property = "timeToStartWork", javaType = java.util.Date.class),
			@Result(column = "computer_certificate", property = "computerCertificate", javaType = java.lang.String.class),
			@Result(column = "professional_qualification", property = "professionalQualification", javaType = java.lang.String.class),
			@Result(column = "professional_speciality", property = "professionalSpeciality", javaType = java.lang.String.class),
			@Result(column = "foreign_languages", property = "foreignLanguages", javaType = java.lang.String.class),
			@Result(column = "foreign_languages_certificate", property = "foreignLanguagesCertificate", javaType = java.lang.String.class),
			@Result(column = "card_id", property = "cardId", javaType = java.lang.String.class),
			@Result(column = "post_id",property ="postId",javaType = java.lang.Integer.class),
			@Result(column = "residence_address", property = "residenceAddress", javaType = java.lang.String.class),
			@Result(column = "is_kin_work_here", property = "isKinWorkHere", javaType = java.lang.Integer.class),
			@Result(column = "resume_type_desc",property="resumeTypeDesc",javaType=java.lang.String.class)
	})
	ResumeBase selectPartByUserId(Integer userId);
	
	
	/**
	 * ��ѯmax���˱��
	 * 
	 * @return
	 */
	@Select("select max(personnel_number) from " + RecruitConstants.RESUMEBASETABLE)
	String selectMaxPersonnelNumber();
	
	

	/**
	 * ��̬�������������Ϣ
	 * 
	 * @param resumeBase
	 */
	@InsertProvider(type = ResumeBaseDynaSqlMapper.class, method = "insertResumeBase")
	void save(ResumeBase resumeBase);
	
	
	/**
	 * ���¼���������Ϣ
	 */
	
	@UpdateProvider(type = ResumeBaseDynaSqlMapper.class,method = "updateResumeBase")
	void update(ResumeBase resumeBase);
	
}
