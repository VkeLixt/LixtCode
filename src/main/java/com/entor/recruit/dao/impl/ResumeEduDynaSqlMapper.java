package com.entor.recruit.dao.impl;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.ResumeEdu;
import com.entor.recruit.utils.RecruitConstants;

public class ResumeEduDynaSqlMapper {

	public String insertResumeEdu(ResumeEdu resumeEdu){
		return new SQL(){
			{
				INSERT_INTO(RecruitConstants.RESUMEEDUCATIONTABLE);
				if(resumeEdu != null){
					if(resumeEdu.getSchoolName()!=null && !resumeEdu.getSchoolName().equals("")){
						VALUES("school_name","#{schoolName}");
					}
					if(resumeEdu.getMajor()!=null && !resumeEdu.getMajor().equals("")){
						VALUES("major", "#{major}");
					}
					if(resumeEdu.getDegree()!=null && !resumeEdu.getDegree().equals("")){
						VALUES("degree", "#{degree}");
					}
					if(resumeEdu.getStartTime()!=null){
						VALUES("start_time", "#{startTime}");
					}
					if(resumeEdu.getEndTime()!= null){
						VALUES("end_time", "#{endTime}");
					}
					if(resumeEdu.getResumeId()!=null){
						VALUES("resume_id", "#{resumeId}");
					}
					if(resumeEdu.getRemark()!=null && !resumeEdu.getRemark().equals("")){
						VALUES("remark", "#{remark}");
					}
					if(resumeEdu.getCreateDate()!=null){
						VALUES("create_date", "#{createDate}");
					}
				}
			}
		}.toString();
	}
	
	public String updateResumeEdu(ResumeEdu resumeEdu){
		return new SQL(){
			{
				UPDATE(RecruitConstants.RESUMEEDUCATIONTABLE);
				if(resumeEdu != null){
					if(resumeEdu.getSchoolName()!=null && !resumeEdu.getSchoolName().equals("")){
						SET("school_name=#{schoolName}");
					}
					if(resumeEdu.getMajor()!=null && !resumeEdu.getMajor().equals("")){
						SET("major=#{major}");
					}
					if(resumeEdu.getDegree()!=null && !resumeEdu.getDegree().equals("")){
						SET("degree=#{degree}");
					}
					if(resumeEdu.getStartTime()!=null){
						SET("start_time=#{startTime}");
					}
					if(resumeEdu.getEndTime()!= null){
						SET("end_time=#{endTime}");
					}
					if(resumeEdu.getResumeId()!=null){
						SET("resume_id=#{resumeId}");
					}
					if(resumeEdu.getRemark()!=null && !resumeEdu.getRemark().equals("")){
						SET("remark=#{remark}");
					}
					if(resumeEdu.getCreateDate()!=null){
						SET("create_date=#{createDate}");
					}
					WHERE("id=#{id}");
				}
				
			}
		}.toString();
	}
	
	
	public String deleteResumeEdu(Map<String, Integer[]> ids){
		return new SQL(){
			{
				if(ids!=null && ids.get("ids")!=null){
					DELETE_FROM(RecruitConstants.RESUMEEDUCATIONTABLE);
					String in=" id in (";
					Integer [] idArr=ids.get("ids");
					
					//Ñ­»·
					for(int index=0;index<idArr.length;index++){
						in +=idArr[index];
						
						if(index!=idArr.length-1){
							in +=",";
						}
					}
					in += ")";
					WHERE(in);
				}
			}
		}.toString();
	}
}
