package com.entor.recruit.dao.impl;

import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.domain.ResumeBase;
import com.entor.recruit.utils.RecruitConstants;

public class ResumeBaseDynaSqlMapper {

	/**
	 * 动态插入简历基本信息
	 * 
	 * @param resumeBase
	 * @return
	 */
	public String insertResumeBase(ResumeBase resumeBase) {
		return new SQL() {
			{
				INSERT_INTO(RecruitConstants.RESUMEBASETABLE);
				if (resumeBase != null) {
					if (resumeBase.getPersonnelNumber() != null && !resumeBase.getPersonnelNumber().equals("")) {
						VALUES("personnel_number", "#{personnelNumber}");
					}
					if (resumeBase.getUserId() != null) {
						VALUES("user_id", "#{userId}");
					}
					if (resumeBase.getName() != null && !resumeBase.getName().equals("")) {
						VALUES("name", "#{name}");
					}
					if (resumeBase.getGender() != null) {
						VALUES("gender", "#{gender}");
					}
					if (resumeBase.getBirthday() != null) {
						VALUES("birthday", "#{birthday}");
					}
					if (resumeBase.getRace() != null && !resumeBase.getRace().equals("")) {
						VALUES("race", "#{race}");
					}
					if (resumeBase.getNativePlace() != null && !resumeBase.getNativePlace().equals("")) {
						VALUES("native_place", "#{nativePlace}");
					}
					if (resumeBase.getOrigin() != null && !resumeBase.getOrigin().equals("")) {
						VALUES("origin", "#{origin}");
					}
					if (resumeBase.getNationality() != null && !resumeBase.getNationality().equals("")) {
						VALUES("nationality", "#{nationality}");
					}
					if (resumeBase.getPermanentAddress() != null && !resumeBase.getPermanentAddress().equals("")) {
						VALUES("permanent_address", "#{permanentAddress}");
					}
					if (resumeBase.getHeight() != null) {
						VALUES("height", "#{height}");
					}
					if (resumeBase.getSourcePlace() != null && !resumeBase.getSourcePlace().equals("")) {
						VALUES("source_place", "#{sourcePlace}");
					}
					if (resumeBase.getParty() != null && !resumeBase.getParty().equals("")) {
						VALUES("party", "#{party}");
					}
					if (resumeBase.getTimeToJoinParty() != null) {
						VALUES("time_to_join_party", "#{timeToJoinParty}");
					}
					if (resumeBase.getHighestEducation() != null && !resumeBase.getHighestEducation().equals("")) {
						VALUES("highest_education", "#{highestEducation}");
					}
					if (resumeBase.getHighestDegree() != null && !resumeBase.getHighestDegree().equals("")) {
						VALUES("highest_degree", "#{highestDegree}");
					}
					if (resumeBase.getEducationSchool() != null && !resumeBase.getEducationSchool().equals("")) {
						VALUES("education_school", "#{educationSchool}");
					}
					if (resumeBase.getMajor() != null && !resumeBase.getMajor().equals("")) {
						VALUES("major", "#{major}");
					}
					if (resumeBase.getCurrEmployer() != null && !resumeBase.getCurrEmployer().equals("")) {
						VALUES("curr_employer", "#{currEmployer}");
					}
					if (resumeBase.getPosition() != null && !resumeBase.getPosition().equals("")) {
						VALUES("position", "#{position}");
					}
					if (resumeBase.getTimeToStartWork() != null) {
						VALUES("time_to_start_work", "#{timeToStartWork}");
					}
					if (resumeBase.getProfessionalQualification() != null
							&& !resumeBase.getProfessionalQualification().equals("")) {
						VALUES("professional_qualification", "#{professionalQualification}");
					}
					if (resumeBase.getForeignLanguages() != null && !resumeBase.getForeignLanguages().equals("")) {
						VALUES("foreign_languages", "#{foreignLanguages}");
					}
					if (resumeBase.getCardId() != null && !resumeBase.getCardId().equals("")) {
						VALUES("card_id", "#{cardId}");
					}
					if (resumeBase.getResidenceAddress() != null && !resumeBase.getResidenceAddress().equals("")) {
						VALUES("residence_address", "#{residenceAddress}");
					}
					if (resumeBase.getPhone() != null && !resumeBase.getPhone().equals("")) {
						VALUES("phone", "#{phone}");
					}
					if (resumeBase.getEmail() != null && !resumeBase.getMarriage().equals("")) {
						VALUES("email", "#{email}");
					}
					if (resumeBase.getMarriage() != null) {
						VALUES("marriage", "#{marriage}");
					}
					if (resumeBase.getCreateDate() != null) {
						VALUES("create_date", "#{createDate}");
					}
					if (resumeBase.getPostId() != null){
						VALUES("post_id","#{postId}");
					}
					VALUES("computer_certificate", "#{computerCertificate}");
					VALUES("professional_speciality", "#{professionalSpeciality}");
					VALUES("foreign_languages_certificate", "#{foreignLanguagesCertificate}");
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}

	/**
	 * 动态更新简历基本信息
	 * 
	 * @param resumeBase
	 * @return
	 */
	public String updateResumeBase(ResumeBase resumeBase) {
		return new SQL() {
			{
				UPDATE(RecruitConstants.RESUMEBASETABLE);
				if (resumeBase != null) {
					if (resumeBase.getPersonnelNumber() != null && !resumeBase.getPersonnelNumber().equals("")) {
						SET("personnel_number = #{personnelNumber}");
					}
					if (resumeBase.getUserId() != null) {
						SET("user_id = #{userId}");
					}
					if (resumeBase.getName() != null && !resumeBase.getName().equals("")) {
						SET("name = #{name}");
					}
					if (resumeBase.getGender() != null) {
						SET("gender = #{gender}");
					}
					if (resumeBase.getBirthday() != null) {
						SET("birthday = #{birthday}");
					}
					if (resumeBase.getRace() != null && !resumeBase.getRace().equals("")) {
						SET("race = #{race}");
					}
					if (resumeBase.getNativePlace() != null && !resumeBase.getNativePlace().equals("")) {
						SET("native_place = #{nativePlace}");
					}
					if (resumeBase.getOrigin() != null && !resumeBase.getOrigin().equals("")) {
						SET("origin = #{origin}");
					}
					if (resumeBase.getNationality() != null && !resumeBase.getNationality().equals("")) {
						SET("nationality = #{nationality}");
					}
					if (resumeBase.getPermanentAddress() != null && !resumeBase.getPermanentAddress().equals("")) {
						SET("permanent_address = #{permanentAddress}");
					}
					if (resumeBase.getHeight() != null) {
						SET("height = #{height}");
					}
					if (resumeBase.getSourcePlace() != null && !resumeBase.getSourcePlace().equals("")) {
						SET("source_place = #{sourcePlace}");
					}
					if (resumeBase.getParty() != null && !resumeBase.getParty().equals("")) {
						SET("party = #{party}");
					}
					if (resumeBase.getTimeToJoinParty() != null) {
						SET("time_to_join_party = #{timeToJoinParty}");
					}
					if (resumeBase.getHighestEducation() != null && !resumeBase.getHighestEducation().equals("")) {
						SET("highest_education = #{highestEducation}");
					}
					if (resumeBase.getHighestDegree() != null && !resumeBase.getHighestDegree().equals("")) {
						SET("highest_degree = #{highestDegree}");
					}
					if (resumeBase.getEducationSchool() != null && !resumeBase.getEducationSchool().equals("")) {
						SET("education_school = #{educationSchool}");
					}
					if (resumeBase.getMajor() != null && !resumeBase.getMajor().equals("")) {
						SET("major = #{major}");
					}
					if (resumeBase.getCurrEmployer() != null && !resumeBase.getCurrEmployer().equals("")) {
						SET("curr_employer = #{currEmployer}");
					}
					if (resumeBase.getPosition() != null && !resumeBase.getPosition().equals("")) {
						SET("position = #{position}");
					}
					if (resumeBase.getTimeToStartWork() != null) {
						SET("time_to_start_work = #{timeToStartWork}");
					}
					if (resumeBase.getProfessionalQualification() != null
							&& !resumeBase.getProfessionalQualification().equals("")) {
						SET("professional_qualification = #{professionalQualification}");
					}
					if (resumeBase.getForeignLanguages() != null && !resumeBase.getForeignLanguages().equals("")) {
						SET("foreign_languages = #{foreignLanguages}");
					}
					if (resumeBase.getCardId() != null && !resumeBase.getCardId().equals("")) {
						SET("card_id = #{cardId}");
					}
					if (resumeBase.getResidenceAddress() != null && !resumeBase.getResidenceAddress().equals("")) {
						SET("residence_address = #{residenceAddress}");
					}
					if (resumeBase.getPhone() != null && !resumeBase.getPhone().equals("")) {
						SET("phone = #{phone}");
					}
					if (resumeBase.getEmail() != null && !resumeBase.getMarriage().equals("")) {
						SET("email = #{email}");
					}
					if (resumeBase.getMarriage() != null) {
						SET("marriage = #{marriage}");
					}
					if (resumeBase.getCreateDate() != null) {
						SET("create_date = #{createDate}");
					}
					if (resumeBase.getComputerCertificate() != null
							&& !resumeBase.getComputerCertificate().equals("")) {
						SET("computer_certificate = #{computerCertificate}");
					}
					if (resumeBase.getProfessionalSpeciality() != null
							&& !resumeBase.getProfessionalSpeciality().equals("")) {
						SET("professional_speciality = #{professionalSpeciality}");
					}
					if (resumeBase.getForeignLanguagesCertificate() != null
							&& !resumeBase.getForeignLanguagesCertificate().equals("")) {
						SET("foreign_languages_certificate = #{foreignLanguagesCertificate}");
					}
					if (resumeBase.getRemark() != null && !resumeBase.getRemark().equals("")) {
						SET("remark = #{remark}");
					}
					if (resumeBase.getPostId() != null){
						SET("post_id=#{postId}");
					}
					WHERE(" id = #{id} ");
				}
			}
		}.toString();
	}
}
