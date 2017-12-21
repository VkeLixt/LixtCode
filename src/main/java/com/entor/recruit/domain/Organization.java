package com.entor.recruit.domain;

import java.io.Serializable;

public class Organization implements Serializable {

	
	private static final long serialVersionUID = -3118385656065791968L;

	private Integer id;
	private String name;
	private String unitName;
	private String remark;
	
	
	public Organization(){
		
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


	public String getUnitName() {
		return unitName;
	}


	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", unitName=" + unitName + ", remark=" + remark + "]";
	}
	
	
	
}
