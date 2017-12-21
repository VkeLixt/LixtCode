package com.entor.recruit.dao.impl;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.RecruitmentPlan;
import com.entor.recruit.utils.RecruitConstants;

public class RecruitmentPlanDynaSqlMapper {

	
	/**
	 * 动态查询招聘计划
	 * 
	 * @param params
	 * @return
	 */
	public String selectWithParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(RecruitConstants.RECRUITMENTPLANTABLE);
				RecruitmentPlan recruitmentPlan = (RecruitmentPlan) params.get("recruitmentPlan");
				if (recruitmentPlan != null) {
					if (recruitmentPlan.getName() != null && !recruitmentPlan.getName().equals("")) {
						WHERE(" name LIKE CONCAT('%',#{name},'%') ");
					}
					if (recruitmentPlan.getExamDistrict() != null && !recruitmentPlan.getExamDistrict().equals("")) {
						WHERE(" exam_district LIKE CONCAT('%',#{examDistrict},'%') ");
					}
					if (recruitmentPlan.getStartTime() != null) {
						WHERE(" start_time LIKE CONCAT('%',#{startTime},'%') ");
					}
					if (recruitmentPlan.getEndTime() != null) {
						WHERE(" end_time LIKE CONCAT('%',#{endTime},'%') ");
					}
				}
			}
		}.toString();
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
		}
		return sql;
	}
	
	
	/**
	 * 动态查询招聘计划总数
	 * 
	 * @param params
	 * @return
	 */
	
	public String count(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM(RecruitConstants.RECRUITMENTPLANTABLE);
				RecruitmentPlan recruitmentPlan = (RecruitmentPlan)params.get("recruitmentPlan");
				if(recruitmentPlan != null){
					if(recruitmentPlan.getName()!=null && !recruitmentPlan.getName().equals("")){
						WHERE(" name LIKE COUCAT('%',#{name},'%')");
					}
					if(recruitmentPlan.getExamDistrict()!=null && !recruitmentPlan.getExamDistrict().equals("")){
						WHERE(" exam_district LIKE COUCAT('%',#{examDistrict},'%')");
					}
					if(recruitmentPlan.getStartTime()!=null){
						WHERE(" start_time LIKE CONCAT('%',#{start_time},'%')");
					}
					if(recruitmentPlan.getEndTime()!=null){
						WHERE(" end_time LIKE CONCAT('%',#{endTime},'%')");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel")!=null){
			sql += " limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
		}
		return sql;
	}
}
