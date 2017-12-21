package com.entor.recruit.dao.impl;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.ResumeWork;
import com.entor.recruit.utils.RecruitConstants;

public class ResumeWorkDynaSqlMapper {

	public String insertResumeWork(ResumeWork resumeWork){
		return new SQL(){
			{
				INSERT_INTO(RecruitConstants.RESUMEWORKTABLE);
				
				if(resumeWork != null){
					if(resumeWork.getUnitName()!=null&& !resumeWork.getUnitName().equals("")){
						VALUES("unit_name", "#{unitName}");
					}
					if(resumeWork.getPosition()!=null && !resumeWork.getPosition().equals("")){
						VALUES("position", "#{position}");
					}
					if(resumeWork.getStartTime()!=null){
						VALUES("start_time", "#{startTime}");
					}
					if(resumeWork.getEndTime()!= null){
						VALUES("end_time", "#{endTime}");
					}
					if(resumeWork.getResumeId()!= null){
						VALUES("resume_id", "#{resumeId}");
					}
					if(resumeWork.getRemark()!= null && !resumeWork.getRemark().equals("")){
						VALUES("remark", "#{remark}");
					}
					if(resumeWork.getCreateDate()!= null){
						VALUES("create_date", "#{createDate}");
					}
				}
			}
		}.toString();
	}
	
	public String updateResumeWork(ResumeWork resumeWork){
		return new SQL(){
			{
				UPDATE(RecruitConstants.RESUMEWORKTABLE);
				if(resumeWork != null){
					if(resumeWork.getUnitName()!=null&& !resumeWork.getUnitName().equals("")){
						SET("unit_name=#{unitName}");
					}
					if(resumeWork.getPosition()!=null && !resumeWork.getPosition().equals("")){
						SET("position=#{position}");
					}
					if(resumeWork.getStartTime()!=null){
						SET("start_time=#{startTime}");
					}
					if(resumeWork.getEndTime()!= null){
						SET("end_time=#{endTime}");
					}
					if(resumeWork.getResumeId()!= null){
						SET("resume_id=#{resumeId}");
					}
					if(resumeWork.getRemark()!= null && !resumeWork.getRemark().equals("")){
						SET("remark=#{remark}");
					}
					if(resumeWork.getCreateDate()!= null){
						SET("create_date=#{createDate}");
					}
					WHERE("id=#{id}");
				}
			}
		}.toString();
	}
	
	public String deleteResumeWork(Map<String, Integer[]> map){
		return new SQL(){
			{
				if(map!=null&&map.get("ids")!=null){
					DELETE_FROM(RecruitConstants.RESUMEWORKTABLE);
					String in=" id in (";
					Integer [] idArr=map.get("ids");
					for(int index =0;index<idArr.length;index++){
						in+=idArr[index];
						if(index != idArr.length-1){
							in+=",";
						}
					}
					in+=")";
					WHERE(in);
				}
			}
		}.toString();
	}
}
