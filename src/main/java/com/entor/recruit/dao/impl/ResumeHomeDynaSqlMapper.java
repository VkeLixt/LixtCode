package com.entor.recruit.dao.impl;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.ResumeHome;
import com.entor.recruit.utils.RecruitConstants;

public class ResumeHomeDynaSqlMapper {

	public String insertResumeHome(ResumeHome resumeHome){
		return new SQL(){
			{
				INSERT_INTO(RecruitConstants.RESUMERELATIONSTABLE);
				
				if(resumeHome != null){
					if(resumeHome.getAppellation()!=null && !resumeHome.getAppellation().equals("")){
						VALUES("appellation", "#{appellation}");
					}
					if(resumeHome.getName()!=null && !resumeHome.getName().equals("")){
						VALUES("name", "#{name}");
					}
					if(resumeHome.getParty()!=null&& !resumeHome.getParty().equals("")){
						VALUES("party", "#{party}");
					}
					if(resumeHome.getNationality()!= null&& !resumeHome.getNationality().equals("")){
						VALUES("nationality", "#{nationality}");
					}
					if(resumeHome.getBirthday()!= null){
						VALUES("birthday", "#{birthday}");
					}
					if(resumeHome.getWorkUnitPosition()!= null&& !resumeHome.getWorkUnitPosition().equals("")){
						VALUES("work_unit_position", "#{workUnitPosition}");
					}
					if(resumeHome.getResumeId()!= null){
						VALUES("resume_id", "#{resumeId}");
					}
					if(resumeHome.getRemark()!= null && !resumeHome.getRemark().equals("")){
						VALUES("remark", "#{remark}");
					}
					if(resumeHome.getCreateDate()!= null){
						VALUES("create_date", "#{createDate}");
					}
				}
			}
		}.toString();
	}
	
	public String updateResumeHome(ResumeHome resumeHome){
		return new SQL(){
			{
				UPDATE(RecruitConstants.RESUMERELATIONSTABLE);
				if(resumeHome != null){
					if(resumeHome.getAppellation()!=null&& !resumeHome.getAppellation().equals("")){
						SET("appellation=#{appellation}");
					}
					if(resumeHome.getName()!=null && !resumeHome.getName().equals("")){
						SET("name=#{name}");
					}
					if(resumeHome.getParty()!=null&& !resumeHome.getParty().equals("")){
						SET("party=#{party}");
					}
					if(resumeHome.getNationality()!= null&& !resumeHome.getNationality().equals("")){
						SET("nationality=#{nationality}");
					}
					if(resumeHome.getBirthday()!= null){
						SET("birthday=#{birthday}");
					}
					if(resumeHome.getWorkUnitPosition()!= null&& !resumeHome.getWorkUnitPosition().equals("")){
						SET("work_unit_position=#{workUnitPosition}");
					}
					if(resumeHome.getResumeId()!= null){
						SET("resume_id=#{resumeId}");
					}
					if(resumeHome.getRemark()!= null && !resumeHome.getRemark().equals("")){
						SET("remark=#{remark}");
					}
					if(resumeHome.getCreateDate()!= null){
						SET("create_date=#{createDate}");
					}
					WHERE("id=#{id}");
				}
			}
		}.toString();
	}
	
	public String deleteResumeHome(Map<String, Integer[]> map){
		return new SQL(){
			{
				if(map!=null&&map.get("ids")!=null){
					DELETE_FROM(RecruitConstants.RESUMERELATIONSTABLE);
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
