package com.entor.recruit.domain;

import java.io.Serializable;
import java.util.Date;

//实现Serializable接口，作用于序列化
public class User implements Serializable {

	private static final long serialVersionUID = -3183330120020561344L;

	private Integer id;
	private String loginname;
	private String password;
	private Integer status;
	private Date createDate;
	private String username;
	private String cardId;
	
	public User(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", password=" + password + ", status=" + status
				+ ", createDate=" + createDate + ", username=" + username + ", cardId=" + cardId + "]";
	}
	
	
}
