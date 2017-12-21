package com.entor.recruit.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ResumeBase implements Serializable {

	private static final long serialVersionUID = -7038068386470842639L;
	
	private Integer id;
	private String personnelNumber;
	private Integer userId;
	private String name;
	private Integer gender;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthday;
	private String race;
	private String nativePlace;
	private String origin;
	private String nationality;
	private String permanentAddress;
	private Integer height;
	private String sourcePlace;
	private String party;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date timeToJoinParty;
	private String highestEducation;
	private String highestDegree;
	private String educationSchool;
	private String major;
	private String currEmployer;
	private String position;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date timeToStartWork;
	private String computerCertificate;
	private String professionalQualification;
	private String professionalSpeciality;
	private String foreignLanguages;
	private String foreignLanguagesCertificate;
	private String cardId;
	private String residenceAddress;
	private String phone;
	private String email;
	private Integer marriage;
	private String remark;
	private Integer isKinWorkHere;
	private String resumeTypeDesc;
	private Integer postId;
	private Date createDate;

	public ResumeBase(){
		
	}

	
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPersonnelNumber() {
		return personnelNumber;
	}
	public void setPersonnelNumber(String personnelNumber) {
		this.personnelNumber = personnelNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Date getTimeToJoinParty() {
		return timeToJoinParty;
	}
	public void setTimeToJoinParty(Date timeToJoinParty) {
		this.timeToJoinParty = timeToJoinParty;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getEducationSchool() {
		return educationSchool;
	}
	public void setEducationSchool(String educationSchool) {
		this.educationSchool = educationSchool;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCurrEmployer() {
		return currEmployer;
	}
	public void setCurrEmployer(String currEmployer) {
		this.currEmployer = currEmployer;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getTimeToStartWork() {
		return timeToStartWork;
	}
	public void setTimeToStartWork(Date timeToStartWork) {
		this.timeToStartWork = timeToStartWork;
	}
	public String getComputerCertificate() {
		return computerCertificate;
	}
	public void setComputerCertificate(String computerCertificate) {
		this.computerCertificate = computerCertificate;
	}
	public String getProfessionalQualification() {
		return professionalQualification;
	}
	public void setProfessionalQualification(String professionalQualification) {
		this.professionalQualification = professionalQualification;
	}
	public String getProfessionalSpeciality() {
		return professionalSpeciality;
	}
	public void setProfessionalSpeciality(String professionalSpeciality) {
		this.professionalSpeciality = professionalSpeciality;
	}
	public String getForeignLanguages() {
		return foreignLanguages;
	}
	public void setForeignLanguages(String foreignLanguages) {
		this.foreignLanguages = foreignLanguages;
	}
	public String getForeignLanguagesCertificate() {
		return foreignLanguagesCertificate;
	}
	public void setForeignLanguagesCertificate(String foreignLanguagesCertificate) {
		this.foreignLanguagesCertificate = foreignLanguagesCertificate;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getIsKinWorkHere() {
		return isKinWorkHere;
	}
	public void setIsKinWorkHere(Integer isKinWorkHere) {
		this.isKinWorkHere = isKinWorkHere;
	}
	public String getResumeTypeDesc() {
		return resumeTypeDesc;
	}
	public void setResumeTypeDesc(String resumeTypeDesc) {
		this.resumeTypeDesc = resumeTypeDesc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	@Override
	public String toString() {
		return "ResumeBase [id=" + id + ", personnelNumber=" + personnelNumber + ", userId=" + userId + ", name=" + name
				+ ", gender=" + gender + ", birthday=" + birthday + ", race=" + race + ", nativePlace=" + nativePlace
				+ ", origin=" + origin + ", nationality=" + nationality + ", permanentAddress=" + permanentAddress
				+ ", height=" + height + ", sourcePlace=" + sourcePlace + ", party=" + party + ", timeToJoinParty="
				+ timeToJoinParty + ", highestEducation=" + highestEducation + ", highestDegree=" + highestDegree
				+ ", educationSchool=" + educationSchool + ", major=" + major + ", currEmployer=" + currEmployer
				+ ", position=" + position + ", timeToStartWork=" + timeToStartWork + ", computerCertificate="
				+ computerCertificate + ", professionalQualification=" + professionalQualification
				+ ", professionalSpeciality=" + professionalSpeciality + ", foreignLanguages=" + foreignLanguages
				+ ", foreignLanguagesCertificate=" + foreignLanguagesCertificate + ", cardId=" + cardId
				+ ", residenceAddress=" + residenceAddress + ", phone=" + phone + ", email=" + email + ", marriage="
				+ marriage + ", remark=" + remark + ", isKinWorkHere=" + isKinWorkHere + ", resumeTypeDesc="
				+ resumeTypeDesc + ", createDate=" + createDate + "]";
	}
	
	
	
	
	
}
