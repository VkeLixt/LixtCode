package com.entor.recruit.domain;

import java.io.Serializable;

public class ResumeType implements Serializable{


	private static final long serialVersionUID = -3703722932528653254L;

	private Integer id;
	private String name;
	private String remark;
	
	public ResumeType(){
		
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ResumeType [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	
	
	
}
