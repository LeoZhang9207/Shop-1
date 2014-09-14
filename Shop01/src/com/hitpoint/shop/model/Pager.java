package com.hitpoint.shop.model;

import java.util.List;

public class Pager<E> {
	private int pageIndex;//�ڼ�ҳ
	private int pageSize;//ÿҳ��ʾ������
	private int pageOffset;//�׷�ũҵ�Ŀ�ʼֵ
	private int totalRecord;//�ܹ���������¼
	private int totalPage;//�ܹ�����ҳ
	private List<E> datas;//���þ�����ݵ��б�
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<E> getDatas() {
		return datas;
	}
	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
}
