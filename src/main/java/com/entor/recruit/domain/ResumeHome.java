package com.entor.recruit.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ResumeHome implements Serializable{

	private static final long serialVersionUID = 8976142373527484804L;

	private Integer id;
	private String appellation;
	private String name;
	private String party;
	private String nationality;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date birthday;
	private String workUnitPosition;
	private Integer resumeId;
	private String remark;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date createDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppellation() {
		return appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getWorkUnitPosition() {
		return workUnitPosition;
	}
	public void setWorkUnitPosition(String workUnitPosition) {
		this.workUnitPosition = workUnitPosition;
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
		return "ResumeHome [id=" + id + ", appellation=" + appellation + ", name=" + name + ", party=" + party
				+ ", nationality=" + nationality + ", birthday=" + birthday + ", workUnitPosition=" + workUnitPosition
				+ ", resumeId=" + resumeId + ", remark=" + remark + ", createDate=" + createDate + "]";
	}
	
	
	
	
	
	
}
