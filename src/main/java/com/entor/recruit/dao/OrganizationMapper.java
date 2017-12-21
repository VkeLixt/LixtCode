package com.entor.recruit.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.entor.recruit.domain.Organization;
import com.entor.recruit.utils.RecruitConstants;

public interface OrganizationMapper {

	/**
	 * ����id��ѯ����
	 * 
	 * @param id
	 * @return
	 */
	
	@Select("select * from " + RecruitConstants.ORGTABLE + " where id = #{id} ")
	@Results(value = { @Result(column = "unit_name", property = "unitName", javaType = java.lang.String.class) })
	Organization selectById(Integer id);
}
