package com.entor.recruit.dao;

import org.apache.ibatis.annotations.Select;

import com.entor.recruit.domain.ResumeType;
import com.entor.recruit.utils.RecruitConstants;

public interface ResumeTypeMapper {

	/**
	 * 根据id查询简历类型
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from " + RecruitConstants.RESUMETYPETABLE + " where id = #{id} ")
	ResumeType selectById(Integer id);
}
