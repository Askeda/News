package com.entity;

import java.util.List;

public class Page {
	private int currPageNo=1;//��ǰҳ
	private int pageSize=10;//ҳ��С
	private int totalCount;//�ܼ�¼��
	private int totalPageCount;//��ҳ��
	private List<Content> newsList;//ÿҳ���ż���
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	
	
	//����ÿҳ��ʾ�����ݸ���
	public void setPageSize(int pageSize) {
		//�ж�ҳ����ÿҳ����ʾ���������Ϊ0���ֵ10Ҫ��ȻΪ�����µ�pageSize
		this.pageSize = pageSize==0?10:pageSize;
	}
	
	
	public int getTotalCount() {
		return totalCount;
	}
	
	//�����ܼ�¼���������ܼ�¼��������ҳ��
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount>0){
			//��С��0ʱ��������Ԫ�����ж������ʾ�ǲ��ǵ���0�����ڽ�����һҳ��ʾ���һ������
			//������ÿҳ��ʾ10�����ݵĳ�ͻ
			totalPageCount=this.totalCount%this.pageSize==0 ?
					this.totalCount/this.pageSize  //���ܳ��������
					:(this.totalCount/this.pageSize)+1;//����������101  10/11
		}else{
			totalPageCount=0;
		}
		
	}
	
	
	
	
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<Content> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<Content> newsList) {
		this.newsList = newsList;
	}
	
}
