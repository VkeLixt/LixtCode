package com.entor.recruit.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ResumeWork implements Serializable {

	
	private static final long serialVersionUID = 1690726664425624482L;

	private Integer id;
	private String unitName;
	private String position;
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
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
		return "ResumeWork [id=" + id + ", unitName=" + unitName + ", position=" + position + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", resumeId=" + resumeId + ", remark=" + remark + ", createDate="
				+ createDate + "]";
	}
	
	
	
	
	
	
	
}
