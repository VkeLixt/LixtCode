package com.entor.recruit.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ResumeEdu implements Serializable {

	private static final long serialVersionUID = -2746584046043121501L;
	
	private Integer id;
	private String schoolName;
	private String major;
	private String degree;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date endTime;
	private Integer resumeId;
	private String remark;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date createDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
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
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ResumeEdu [id=" + id + ", schoolName=" + schoolName + ", major=" + major + ", degree=" + degree
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", resumeId=" + resumeId + ", remark=" + remark
				+ ", createDate=" + createDate + "]";
	}

	
	
	
	
}
