package com.entor.recruit.utils;

import java.util.List;

public class PageModel<T>{

	private int firstLimitParam;//ƫ����
	private int recordCount;//��ҳ����������
	private int pageIndex; //��ǰҳ
	private int pageSize = RecruitConstants.PAGE_DEFAULT_SIZE;//ÿҳ��¼����Ĭ��Ϊ6
	private int totalSize;//��ҳ��
	private List<T> list;//��ҳ����
	
	/**
	 * ��ҳƫ������limit�ĵ�1��������
	 * 
	 * @return
	 */
	public int getFirstLimitParam() {
		this.firstLimitParam = (this.getPageIndex() -1) * this.pageSize;
		return firstLimitParam;
	}
	public void setFirstLimitParam(int firstLimitParam) {
		this.firstLimitParam = firstLimitParam;
	}
	public int getRecordCount() {
		
		this.recordCount = this.recordCount<=0 ? 0 : this.recordCount;
		return recordCount;
	}
	
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageIndex() {
		// �����ǰҳ��С��0������Ϊ1
		this.pageIndex = this.pageIndex <=0 ? 1 : this.pageIndex;
		// �����ǰҳ�������ҳ��������Ϊ���ҳ��
		this.pageIndex = this.pageIndex >= this.getTotalSize() ? this.getTotalSize() : this.pageIndex;
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		// ���ÿҳ��ʾ��¼��С��Ĭ�Ϸ�ҳ��������ΪĬ�Ϸ�ҳ��
		
		this.pageSize = this.pageSize <= RecruitConstants.PAGE_DEFAULT_SIZE ? RecruitConstants.PAGE_DEFAULT_SIZE : this.pageSize;
		
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		// ���û�м�¼��Ҳ��û�з�ҳ
		if(this.getRecordCount() <= 0){
			this.totalSize = 0;
		}else{
			// ������ҳ��
			this.totalSize = (this.getRecordCount() - 1)/ this.getPageSize() + 1;
		}
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	
}
