package com.entor.recruit.dao.impl;


import org.apache.ibatis.jdbc.SQL;

import com.entor.recruit.utils.RecruitConstants;



public class NoticeDynaSqlMapper {

	//��������������
	public String selectLatestNotice() {
		String sql = new SQL(){
			{
				SELECT("*");
				FROM (RecruitConstants.NOTICETABLE);
				ORDER_BY("create_date desc");
			}
		}.toString();
		
		sql += " limit 1,5 ";
		return sql;
	}

}
