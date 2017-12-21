package com.entor.recruit.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.entor.recruit.dao.impl.NoticeDynaSqlMapper;
import com.entor.recruit.domain.Notice;

public interface NoticeMapper {

	
	@SelectProvider(type = NoticeDynaSqlMapper.class,method="selectLatestNotice")
	@Results(value = { @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
			@Result(column = "user_id", property = "user", javaType = com.entor.recruit.domain.User.class,
			one = @One(select = "com.entor.recruit.dao.UserMapper.selectById", fetchType = FetchType.EAGER))
	})
	List<Notice> selectLatestNotice();
}
