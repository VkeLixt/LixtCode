package com.entor.recruit.domain;

import java.io.Serializable;

public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7678837338938099999L;

	private Integer id;
	private String description;
	private String path;
	private Integer userId;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Photo [id=" + id + ", description=" + description + ", path=" + path + ", userId=" + userId
				+ ", remark=" + remark + "]";
	}

	 
	
	
}
