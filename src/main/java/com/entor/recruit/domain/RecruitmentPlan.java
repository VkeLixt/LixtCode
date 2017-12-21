package com.entor.recruit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * ’–∆∏º∆ªÆ¿‡
 * 
 * 
 *
 */
public class RecruitmentPlan implements Serializable {

	private static final long serialVersionUID = -6487157897491899087L;

	private Integer id;
	private String name;
	private String examDistrict;
	private List<Post> postList;
	private Date startTime;
	private Date endTime;
	private String remark;
	
	public RecruitmentPlan(){
		
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

	public String getExamDistrict() {
		return examDistrict;
	}

	public void setExamDistrict(String examDistrict) {
		this.examDistrict = examDistrict;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
