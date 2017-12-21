package com.entor.recruit.domain;

import java.io.Serializable;

/**
 * ¸ÚÎ»Àà
 * 
 */
public class Post implements Serializable {

	private static final long serialVersionUID = 717945771164508788L;

	private Integer id;
	private String name;
	private String requirements;
	private Organization organization;
	private ResumeType resumeType;
	private Integer recruitmentPlanId;
	private String remark;
	
	
	public Post(){
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRequirements() {
		return requirements;
	}


	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}


	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	public ResumeType getResumeType() {
		return resumeType;
	}


	public void setResumeType(ResumeType resumeType) {
		this.resumeType = resumeType;
	}


	public Integer getRecruitmentPlanId() {
		return recruitmentPlanId;
	}


	public void setRecruitmentPlanId(Integer recruitmentPlanId) {
		this.recruitmentPlanId = recruitmentPlanId;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
