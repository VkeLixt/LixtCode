package com.entor.recruit.service;

import java.util.List;

import com.entor.recruit.domain.Notice;

public interface NoticeService {

	List<Notice> findLatestNotice();
}
